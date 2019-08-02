package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.ScreenInreface;
import com.shaoyuan.core.persenter.ScreenPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.ScreenModel;
import com.shaoyuan.model.personalBean.PhysicalListBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.ScreenAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MedicalActivity extends BaseActivity implements ScreenInreface.view {
    private static final String Tag = "MedicalActivity";
    private ScreenPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.recycler_view)RecyclerView mItem;

    private List<PhysicalListBean.PhysicallistBean> list = new ArrayList<>();
    private int postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_medical;
    }

    @OnClick({R.id.iv_back,R.id.rl_screen})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_screen:        //  筛选
                toScreenPage();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_home_module_medical);
        presenter = new ScreenPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initScreenDatas();    //  初始化健康体检列表数据
    }

    @Override
    public void initScreenDatas(PhysicalListBean model) {
        list = model.getPhysicallist();
        mItem.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ScreenAdapter adapter = new ScreenAdapter(this, model.getPhysicallist());

        mItem.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> {
            postion = position;
            toPlasticPage();
        });
    }

    @Override
    public void toScreenPage() {
        startActivity(new Intent(this, SelectScreenActivity.class));
    }

    @Override
    public void toPlasticPage() {
        String setmealid = list.get(postion).getSetmealid();
        startActivity(new Intent(this,PlasticSurgeryActivity.class).putExtra("setmealid",setmealid));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
