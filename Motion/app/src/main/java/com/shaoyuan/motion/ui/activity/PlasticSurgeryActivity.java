package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.PlasticSurgeryInterface;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PlasticSurgeryActivity extends BaseActivity implements PlasticSurgeryInterface.view {
    private static final String Tag = "PlasticSurgeryActivity";
    @BindView(R.id.tv_back_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plastic_surgery;
    }

    @OnClick({R.id.iv_back,R.id.tv_reservation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_reservation:
                toOrderPage();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText("体检中心");
    }

    @Override
    public void initData() {

    }

    @Override
    public void toOrderPage() {
        startActivity(new Intent(this,BookingOrderActivity.class));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
