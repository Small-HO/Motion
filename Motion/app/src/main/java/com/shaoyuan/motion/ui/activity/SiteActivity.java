package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SiteInterface;
import com.shaoyuan.core.persenter.SitePresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dierbanBean.JudgeCoactBean;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.model.dierbanBean.SiteScreenBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.SiteAdapter;
import com.shaoyuan.motion.ui.view.sitepopwindow.AreaPopupWindow;

import butterknife.BindView;
import butterknife.OnClick;

public class SiteActivity extends BaseActivity implements SiteInterface.view {

    private static final String Tag = "SiteActivity";
    @BindView(R.id.tv_back_title)
    TextView mTitle;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_venue)
    TextView tvVenue;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_distance)
    TextView tvDistance;
    @BindView(R.id.tv_course)
    TextView tvCourse;
    @BindView(R.id.rec_user_venue)
    RecyclerView recUserVenue;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.img_jiaru)
    ImageView imgJiaRu;
    @BindView(R.id.line_user)
    LinearLayout lineUser;
    @BindView(R.id.line_course)
    LinearLayout lineCourse;
    //Popwindow
    private AreaPopupWindow diyPopupWindow;
    private SitePresenter presenter;
    private String pertype;
    private SiteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_site;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_home_module_site);
        imgJiaRu.setVisibility(View.VISIBLE);
        presenter = new SitePresenter(this);
    }

    @Override
    public void initData() {
        presenter.submit();
    }

    @OnClick({ R.id.tv_area, R.id.tv_venue, R.id.tv_price, R.id.tv_distance,R.id.iv_back,R.id.img_jiaru})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //区域选择
            case R.id.tv_area:
                if (diyPopupWindow == null) {
                    diyPopupWindow = new AreaPopupWindow(this);
                    diyPopupWindow.setMaskViewBackColor(0x6f000000);
                }
                diyPopupWindow.setAnimationStyle(android.R.style.Animation_Toast);
                //diyPopupWindow.setBackgroundDrawable(new ColorDrawable(0X00000000));
                diyPopupWindow.showViewBottom(lineUser,0);

                break;
            //场馆分类
            case R.id.tv_venue:
                break;
            //价格筛选
            case R.id.tv_price:
                break;
            //距离排序
            case R.id.tv_distance:
                break;
            case R.id.iv_back:
                finish();
                break;
            //成为教练，场馆入口
            case R.id.img_jiaru:
                setPopwindow();
                break;
        }
    }

    //判断是不是教练
    @Override
    public void initJudgeCoact(JudgeCoactBean judgeCoactBean) {
//        stopload();
        pertype = judgeCoactBean.getPertype();
        //教练0    用户 1
        if(pertype.equals("0")){
            lineCourse.setVisibility(View.VISIBLE);
            tvArea.setText("功能");
            tvVenue.setText("器械");
            tvDistance.setText("私教");
            tvPrice.setText("面积");
            tvCourse.setText("团课");
        }
    }

    @Override
    public void intJudgeCoacts(JudgeCoactBean judgeCoactBean) {
        pertype = judgeCoactBean.getPertype();
        //Constants.PERTYPE=pertype;
        if(pertype.equals("1")){
            lineCourse.setVisibility(View.GONE);
            tvArea.setText("区域选择");
            tvVenue.setText("场馆分类");
            tvDistance.setText("距离排序");
            tvPrice.setText("价格筛选");

        }
    }

    //场地预约列表
    @Override
    public void site(SiteBean siteBean) {
        adapter = new SiteAdapter(this,siteBean.getData());
        recUserVenue.setLayoutManager(new LinearLayoutManager(this));
        recUserVenue.setAdapter(adapter);
        adapter.setOnItemClickListener(new SiteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(SiteActivity.this,SiteDetailActivity.class);
                intent.putExtra("machid",siteBean.getData().get(position).getMachid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void initSiteScreen(SiteScreenBean siteScreenBean) {

    }

//    @Override
//    public String getperType() {
//        Log.e("测",pertype);
//        return pertype;
//    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }


    //成为教练，场馆入口
    private void setPopwindow(){
        View inflate = LayoutInflater.from(this).inflate(R.layout.popwindow_entrance, null);
        PopupWindow popupWindow=new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,false);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x0000000));
        popupWindow.showAsDropDown(imgJiaRu,0,0);
        //场馆加入我们
        LinearLayout line_venue_join = inflate.findViewById(R.id.line_venue_join);
        line_venue_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                startActivity(new Intent(SiteActivity.this,VenueAddActivity.class));
            }
        });
    }
}
