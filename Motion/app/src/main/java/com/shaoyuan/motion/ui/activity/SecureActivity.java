package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SecureInterface;
import com.shaoyuan.core.persenter.SecurePresenter;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SecureActivity extends BaseActivity implements SecureInterface.view {
    private static final String Tag = "SecureActivity";
    private SecurePresenter presenter;

    @BindView(R.id.et_old_pas)EditText mOldPas;
    @BindView(R.id.et_new_pas)EditText mNewPas;
    @BindView(R.id.et_new)EditText mRetype;
    @BindView(R.id.tv_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @OnClick({R.id.iv_back,R.id.tv_ok,R.id.tv_updata_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_ok:
                presenter.updatePas();
                break;
            case R.id.tv_updata_more:
                toSmsCheck();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_secure;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_module_secure);
        presenter = new SecurePresenter(this);
    }

    @Override
    public void toSmsCheck() {
        startActivity(new Intent(this,SmsCheckActivity.class));
    }

    @Override
    public String getOldPwd() {
        return mOldPas.getText().toString();
    }

    @Override
    public String getNewPwd() {
        return mNewPas.getText().toString();
    }

    @Override
    public String getRetype() {
        return mRetype.getText().toString();
    }
}
