package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.ExpendInterface;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ConsumeActivity extends BaseActivity implements ExpendInterface.view {

    @BindView(R.id.tv_back_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText("消耗");
    }

    @OnClick({R.id.iv_back,R.id.iv_add_work,R.id.iv_sleep_add,R.id.iv_exercise_add,R.id.iv_fashion_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add_work:      //  工作
                toWorkPage();
                break;
            case R.id.iv_sleep_add:     //  睡眠

                break;
            case R.id.iv_exercise_add:  //  运动

                break;
            case R.id.iv_fashion_add:   //  体闲

                break;
            case R.id.iv_housewife_add: //  家务

                break;
            case R.id.iv_dailylife_add: //  日常生活

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_consume;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void toWorkPage() {
        startActivity(new Intent(this,WorkActivity.class));
    }
}
