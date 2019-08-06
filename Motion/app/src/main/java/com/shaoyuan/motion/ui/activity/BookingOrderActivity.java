package com.shaoyuan.motion.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.BookingOrderInterface;
import com.shaoyuan.core.persenter.BookingOrderPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.core.utils.MyToast;
import com.shaoyuan.core.utils.SharedPreferencesUtils;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.dialog.CalendarDialog;
import com.shaoyuan.motion.ui.dialog.PayDialog;
import com.shaoyuan.motion.utils.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("SetTextI18n")
public class BookingOrderActivity extends BaseActivity implements BookingOrderInterface.view , RadioGroup.OnCheckedChangeListener {
    private static final String Tag = "BookingOrderActivity";
    private BookingOrderPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.tv_hint)TextView mHint;

    @BindView(R.id.iv_image)ImageView mImage;
    @BindView(R.id.tv_commodit_name)TextView mName;
    @BindView(R.id.tv_context)TextView mContext;
    @BindView(R.id.tv_item_current_price)TextView mCurrentPrice;
    @BindView(R.id.tv_original_price)TextView mOriginalPrice;

    @BindView(R.id.tv_commodity_show_num)TextView mNum;

    @BindView(R.id.et_name)EditText mUserName;
    @BindView(R.id.et_phone)EditText mUserPhone;
    @BindView(R.id.tv_time)TextView mTime;
    @BindView(R.id.tv_card)EditText mCard;
    @BindView(R.id.et_hint)EditText mRemark;

    @BindView(R.id.tv_current_price)TextView mFooterCurrentPrice;
    @BindView(R.id.ealprices2)TextView mFooterEalprices;

    @BindView(R.id.sex_rg)RadioGroup mSex;

    private CalendarDialog dialog;
    private PayDialog mPayDialog;

    private int i = 1;
    private String sex = "男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_booking_order;
    }

    @OnClick({R.id.iv_back,R.id.iv_add,R.id.iv_sub,R.id.tv_time,R.id.tv_reservation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                i ++;
                mNum.setText(i + "");
                mFooterCurrentPrice.setText("￥" + Float.parseFloat(getIntent().getStringExtra("setmealprice")) * i);
                break;
            case R.id.iv_sub:
                if (i > 1) {
                    i --;
                }
                mNum.setText(i + "");
                mFooterCurrentPrice.setText("￥" + Float.parseFloat(getIntent().getStringExtra("setmealprice")) * i);
                break;
            case R.id.tv_time:
                showTimeDialog();
                break;
            case R.id.tv_reservation:
                presenter.submit();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText("预约订单");
        mNum.setText(i + "");

        //  改变颜色 Ceshi
        SpannableStringBuilder builder = new SpannableStringBuilder(mHint.getText().toString());
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        builder.setSpan(colorSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mHint.setText(builder);

        dialog = new CalendarDialog(this);
        mPayDialog = new PayDialog(this);

        presenter = new BookingOrderPresenter(this);
        mSex.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {
        presenter.initCommodityData();
    }

    @Override
    public void initCommodityData() {
        ImageLoader.displayImage(this, getIntent().getStringExtra("pic"),mImage);
        mName.setText(getIntent().getStringExtra("setmealname"));                       //  订单名称
        mContext.setText(getIntent().getStringExtra("mechname"));                       //  订单内容
        mCurrentPrice.setText("￥" + getIntent().getStringExtra("setmealprice"));       //  订单现价
        mOriginalPrice.setText("￥" + getIntent().getStringExtra("setmealprices"));     //  订单原价
        mOriginalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        mFooterCurrentPrice.setText("￥" + getIntent().getStringExtra("setmealprice")); //   footer现价
        mFooterEalprices.setText("￥" + getIntent().getStringExtra("setmealprices"));   //   footer原价
        mFooterEalprices.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);



        SharedPreferencesUtils.saveString(getContext(), Constants.subject,getIntent().getStringExtra("setmealname"));
        SharedPreferencesUtils.saveString(getContext(), Constants.price,getIntent().getStringExtra("setmealprice"));
    }

    @Override
    public String getID() {
        String setmealid = getIntent().getStringExtra("setmealid");
        return setmealid;
    }

    @Override
    public String getName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPhone() {
        return mUserPhone.getText().toString();
    }

    @Override
    public String getTime() {
        return mTime.getText().toString();
    }

    @Override
    public String getCard() {
        return mCard.getText().toString();
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public String getRemark() {
        return mRemark.getText().toString();
    }

    @Override
    public String getPrice() {
        return getIntent().getStringExtra("setmealprice");
    }

    @Override
    public void showTimeDialog() {
        //自定义日历弹窗
        dialog.setOnSelectedListener(time -> mTime.setText(time));
        dialog.show();
    }

    @Override
    public void showPayDialog() {
        mPayDialog.show();
    }

    @Override
    public void showLog(String log)
    {
        LogUtils.i(Tag,log);
    }

    @Override
    public void showToast(String e) {
        MyToast.showToast(this,e);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.male_rb:
                sex = "男";
                break;
            case R.id.famale_rb:
                sex = "女";
                break;
        }
    }
}
