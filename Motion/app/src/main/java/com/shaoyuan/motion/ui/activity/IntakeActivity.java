package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.IntakeInterface;
import com.shaoyuan.core.persenter.IntakePresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.view.EnergyProgressBar;

import butterknife.BindView;
import butterknife.OnClick;

public class IntakeActivity extends BaseActivity implements IntakeInterface.view {
    private static final String Tag = "IntakeActivity";
    private IntakePresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.EnergyProgressBar)EnergyProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @OnClick({R.id.iv_back,R.id.tv_reporter,R.id.rl_motion,R.id.rl_diet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_reporter:
                toAnalysisPage();
                break;
            case R.id.rl_motion:
                toConsumePage();
                break;
            case R.id.rl_diet:
                toDietPage();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_intake;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        startload();
        mTitle.setText(R.string.tv_data_module_intake);
        presenter = new IntakePresenter(this);
    }

    @Override
    public void initData() {
        presenter.initCountcontodyData();
    }

    @Override
    public void initCountcontodyData(CountcontodayModel model) {
        stopload();
        mProgress.setData(80);
    }

    @Override
    public void toAnalysisPage() {
        startActivity(new Intent(this,AnalysisReportsActivity.class));
    }

    @Override
    public void toConsumePage() {
        startActivity(new Intent(this,ConsumeActivity.class));
    }

    @Override
    public void toDietPage() {
        startActivity(new Intent(this,DietActivity.class));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
