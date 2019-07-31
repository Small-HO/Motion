package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.OrderInterface;
import com.shaoyuan.core.persenter.OrderPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.OrderAdapter;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity implements OrderInterface.view {
    private static final String Tag = "OrderActivity";
    private static OrderPresenter mOrderPresenter;
    String str="测试";

    @BindView(R.id.tv_back_title) TextView mTitle;
    @BindView(R.id.recycler_view) RecyclerView mOrderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
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
    protected int getLayoutId() {
        return R.layout.activity_oreder;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_order_list);
        mOrderPresenter = new OrderPresenter(this);
    }

    @Override
    public void initData() {
        mOrderPresenter.initOrderDatas();   //  初始化订单列表
    }

    @Override
    public void initOrderDatas(OrderModel model) {
        mOrderList.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        mOrderList.setAdapter(new OrderAdapter(this,model.getOrderInfos()));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
