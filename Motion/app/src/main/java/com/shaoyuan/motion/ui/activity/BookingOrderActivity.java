package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.BookingOrderInterface;
import com.shaoyuan.core.persenter.BookingOrderPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BookingOrderActivity extends BaseActivity implements BookingOrderInterface.view {
    private static final String Tag = "BookingOrderActivity";
    private BookingOrderPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.tv_hint)TextView mHint;

    @BindView(R.id.iv_image)ImageView mImage;
    @BindView(R.id.tv_commodit_name)TextView mName;
    @BindView(R.id.tv_context)TextView mContext;
    @BindView(R.id.tv_current_price)TextView mCurrentPrice;
    @BindView(R.id.tv_original_price)TextView mOriginalPrice;

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

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
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
        //  改变颜色 Ceshi
        SpannableStringBuilder builder = new SpannableStringBuilder(mHint.getText().toString());
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        builder.setSpan(colorSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mHint.setText(builder);

        presenter = new BookingOrderPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initCommodityData();
        presenter.submit();
    }

    @Override
    public void initCommodityData() {
        ImageLoader.displayImage(this, getIntent().getStringExtra("pic"),mImage);
        mName.setText(getIntent().getStringExtra("setmealname"));
        mContext.setText(getIntent().getStringExtra("mechname"));
        mCurrentPrice.setText(getIntent().getStringExtra("setmealprice"));
        mOriginalPrice.setText(getIntent().getStringExtra("setmealprices"));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
