package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SelectScreenInterface;
import com.shaoyuan.core.persenter.SelectScreenPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.IllnessModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.CrowdAdapter;
import com.shaoyuan.motion.adapter.IllnessAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectScreenActivity extends BaseActivity implements SelectScreenInterface.view {
    private static final String Tag = "SelectScreenActivity";
    private SelectScreenPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;

    @BindView(R.id.recycler_view_crowd)RecyclerView mCrowd;
    @BindView(R.id.recycler_view_illness)RecyclerView mIllness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_screen;
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
        mTitle.setText(R.string.tv_select_project);
        presenter = new SelectScreenPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initCrowdData();
        presenter.initIllnessData();
    }

    @Override
    public void initCrowdData(IllnessModel model) {
        mCrowd.setLayoutManager(new GridLayoutManager(this,4));
        mCrowd.setAdapter(new CrowdAdapter(this,model.getList()));
    }

    @Override
    public void initIllnessData(IllnessModel model) {
        mIllness.setLayoutManager(new GridLayoutManager(this,4));
        mIllness.setAdapter(new IllnessAdapter(this,model.getList()));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
