package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.shaoyuan.core.Interfaces.HeaderInterface;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.dialog.DialogCamera;

import butterknife.OnClick;

public class HeaderActivity extends BaseActivity implements HeaderInterface.view {

    private DialogCamera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @OnClick({R.id.tv_header_back,R.id.iv_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_header_back:
                finish();
                break;
            case R.id.iv_more:
                camera.show();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_header;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        camera = new DialogCamera(this);
    }

    @Override
    public void initData() {

    }
}
