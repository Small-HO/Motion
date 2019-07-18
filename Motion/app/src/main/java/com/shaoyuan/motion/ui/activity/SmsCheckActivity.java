package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SmsCheckInterface;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.CountDownUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SmsCheckActivity extends BaseActivity implements SmsCheckInterface.view {

    @BindView(R.id.tv_title)TextView mTitle;
    @BindView(R.id.tv_time)TextView mTime;
    private CountDownUtils mTimeCount;      //  计时器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @OnClick({R.id.iv_back,R.id.tv_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_time:
                mTimeCount.start();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smscheck;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_module_smscheck);
        mTimeCount = new CountDownUtils(60000,1000,mTime);
    }

    @Override
    public void initData() {

    }
}
