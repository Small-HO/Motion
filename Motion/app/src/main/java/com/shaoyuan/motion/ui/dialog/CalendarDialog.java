package com.shaoyuan.motion.ui.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.classic.adapter.BaseAdapterHelper;
import com.classic.adapter.CommonRecyclerAdapter;
import com.shaoyuan.core.utils.MyToast;
import com.shaoyuan.model.dataModel.CalendarModel;
import com.shaoyuan.motion.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 自定义日历
 *
 * @author Administrator
 */
public class CalendarDialog extends Dialog {
    private OnSelectedListener listener;
    Context context;
    private RecyclerView weekrecyclerView, mothrecyclerView;
    private TextView date;
    private CommonRecyclerAdapter<String> weekadapter;
    private CommonRecyclerAdapter<CalendarModel> mothadapter;
    private List<String> weeklist = new ArrayList<>();
    private List<CalendarModel> mothlist = new ArrayList<>();
    private String week[] = {"日", "一", "二", "三", "四", "五", "六"};
    private int monthnum;
    private int mYear;
    private int mMonth;
    private int Month;
    private int mDay;
    private int mWay;
    int today_moth, today_day, today_year;
    private int selectposition;


    public CalendarDialog(Context context) {
        super(context, R.style.alert_dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_calendar);
        //设置显示dialog后,触屏屏幕不会使dialog消失
        setCanceledOnTouchOutside(false);
        weekrecyclerView = findViewById(R.id.weekrecyclerView);
        mothrecyclerView = findViewById(R.id.mothrecyclerView);
        date = findViewById(R.id.date);
        findViewById(R.id.img).setOnClickListener(v -> dismiss());
        findViewById(R.id.left).setOnClickListener(v -> {
            selectposition = 100;
            mMonth--;
            if (mMonth == 0) {
                mMonth = 12;
                mYear--;
            }
            date.setText(mYear + " / " + mMonth);
            getmoth(getDayofWeek(mYear + "-" + String.format("%02d", mMonth)
                    + "-" + "01"), mMonth, mYear);
        });
        findViewById(R.id.right).setOnClickListener(v -> {
            selectposition = 100;
            mMonth++;
            if (mMonth == 13) {
                mMonth = 1;
                mYear++;
            }
            date.setText(mYear + " / " + mMonth);
            getmoth(getDayofWeek(mYear + "-" + String.format("%02d", mMonth)
                    + "-" + "01"), mMonth, mYear);
        });
        for (int i = 0; i < week.length; i++) {
            weeklist.add(week[i]);
        }
        weekadapter = new CommonRecyclerAdapter<String>(context, R.layout.item_week, weeklist) {
            @Override
            public void onUpdate(BaseAdapterHelper helper, String item, int position) {
                helper.setText(R.id.week, item);
            }
        };
        weekrecyclerView.setLayoutManager(new GridLayoutManager(context, 7));
        weekrecyclerView.setAdapter(weekadapter);


        mothadapter = new CommonRecyclerAdapter<CalendarModel>(context, R.layout.item_day, mothlist) {
            @Override
            public void onUpdate(BaseAdapterHelper helper, CalendarModel item, int position) {
                helper.setText(R.id.day, item.getName());
                //TextView tv = helper.getView(R.id.day);
                helper.getView(R.id.day).setVisibility(View.VISIBLE);
                if (item.isToday()) {
                    helper.getView(R.id.day).setBackground(ContextCompat.getDrawable(context, R.drawable.circular_hollow_green));
                }
                if (item.getName().equals("00")) {
                    helper.getView(R.id.day).setVisibility(View.INVISIBLE);
                } else {
                    if (mYear < today_year) {
                        helper.setTextColor(R.id.day, Color.parseColor("#999999"));
                    } else {
                        if (mMonth < today_moth) {
                            helper.setTextColor(R.id.day, Color.parseColor("#999999"));
                        } else if (mMonth == today_moth) {
                            if (Integer.parseInt(item.getName()) < today_day) {
                                helper.setTextColor(R.id.day, Color.parseColor("#999999"));
                            }
                        } else {
                            helper.setTextColor(R.id.day, Color.parseColor("#333333"));
                        }
                    }
                }
                if (selectposition == position) {
                    helper.getView(R.id.day).setBackground(ContextCompat.getDrawable(context, R.drawable.circular_solid_green));
                    helper.setTextColor(R.id.day, Color.WHITE);
                }
            }
        }

        ;
        mothrecyclerView.setLayoutManager(new GridLayoutManager(context, 7));
        mothrecyclerView.setAdapter(mothadapter);
        mothadapter.setOnItemClickListener((viewHolder, view, position) -> {
            if (!mothadapter.getData().get(position).getName().equals("00")) {

                if (mYear >= today_year) {
                    if (mMonth == today_moth) {
                        if (Integer.parseInt(mothadapter.getData().get(position).getName()) > today_day) {
                            selectposition = position;
                            listener.getData(mYear + "-" + mMonth + "-" + mothadapter.getData().get(position).getName());
                        } else {
                            MyToast.showToast(context, "当前时间不能预约");
                            return;
                        }
                    } else if (mMonth > today_moth) {
                        selectposition = position;
                        listener.getData(mYear + "-" + mMonth + "-" + mothadapter.getData().get(position).getName());
                    } else {
                        MyToast.showToast(context, "当前时间不能预约");
                        return;
                    }
                    dismiss();
                    mothadapter.notifyDataSetChanged();
                } else {
                    MyToast.showToast(context, "当前时间不能预约");
                }
            }
        });

        StringData();
        getmoth(getDayofWeek(mYear + "-" + String.format("%02d", mMonth)
                + "-" + "01"), mMonth, mYear);
    }

    void getmoth(int weekday, int month, int year) {
        mothlist.clear();
        mothadapter.clear();
        for (int i = 0; i < 42; i++) {
            CalendarModel t = new CalendarModel();
            if (mMonth == Month) {
                if (i - weekday + 2 == mDay) {
                    t.setToday(true);
                } else {
                    t.setToday(false);
                }
            }

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                monthnum = 31;
                if (i < weekday - 1 || i > 31 + weekday - 2) {
                    t.setName("00");
                    mothlist.add(t);
                } else {
                    t.setName(i - weekday + 2 + "");
                    mothlist.add(t);
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                monthnum = 30;
                if (i < weekday - 1 || i > 30 + weekday - 2) {
                    t.setName("00");
                    mothlist.add(t);
                } else {
                    t.setName(i - weekday + 2 + "");
                    mothlist.add(t);
                }
            } else if (mMonth == 2) {
                String is = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? "是闰年" : "不是闰年";
                if (is.equals("是闰年")) {
                    monthnum = 29;
                    if (i < weekday - 1 || i > 29 + weekday - 2) {
                        t.setName("00");
                        mothlist.add(t);
                    } else {
                        t.setName(i - weekday + 2 + "");
                        mothlist.add(t);
                    }
                } else {
                    monthnum = 28;
                    if (i < weekday - 1 || i > 28 + weekday - 2) {
                        t.setName("00");
                        mothlist.add(t);
                    } else {
                        t.setName(i - weekday + 2 + "");
                        mothlist.add(t);
                    }
                }
            }
        }
        mothadapter.addAll(mothlist);
        mothadapter.notifyDataSetChanged();
    }

    public void StringData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = c.get(Calendar.YEAR); // 获取当前年份
        mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        Month = c.get(Calendar.MONTH) + 1;// 获取当前月份
        mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当前月份的日期号码
        mWay = c.get(Calendar.DAY_OF_WEEK);
        date.setText(mYear + " / " + mMonth);
        today_moth = c.get(Calendar.MONTH) + 1;
        today_day = c.get(Calendar.DAY_OF_MONTH);
        today_year = c.get(Calendar.YEAR); // 获取当前年份
    }

    private int getDayofWeek(String dateTime) {
        Calendar cal = Calendar.getInstance();
        if (dateTime.equals("")) {
            cal.setTime(new Date(System.currentTimeMillis()));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date;
            try {
                date = sdf.parse(dateTime);
            } catch (ParseException e) {
                date = null;
                e.printStackTrace();
            }
            if (date != null) {
                cal.setTime(new Date(date.getTime()));
            }
        }
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public interface OnSelectedListener {
        void getData(String time);

    }

    public void setOnSelectedListener(OnSelectedListener listener) {
        this.listener = listener;
    }

}
