package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    public void initCrowdData(final IllnessModel model) {
        mCrowd.setLayoutManager(new GridLayoutManager(this,4));
        final CrowdAdapter adapter = new CrowdAdapter(this, model.getList());
        mCrowd.setAdapter(adapter);

        adapter.setOnItemClickListener(new CrowdAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(),"测试",Toast.LENGTH_SHORT).show();
                if (model.getList().get(position).isSelected()) {
                    model.getList().get(position).setSelected(false);
                }else {
                    model.getList().get(position).setSelected(true);
                }
            }
        });
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
