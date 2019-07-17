package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.UserInfoInterface;
import com.shaoyuan.core.persenter.UserInfoPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class UserActivity extends BaseActivity implements UserInfoInterface.view {
    private static final String Tag = "UserActivity";
    private UserInfoPresenter presenter;

    @BindView(R.id.tv_back_title) TextView mTitle;
    @BindView(R.id.et_name)EditText mName;
    @BindView(R.id.rb_man)RadioButton mMan;
    @BindView(R.id.rb_woman)RadioButton mWoman;
    @BindView(R.id.tv_birthday)TextView mBirthday;
    @BindView(R.id.tv_stature)TextView mStature;
    @BindView(R.id.tv_weight)TextView mWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @OnClick({R.id.iv_back,R.id.tv_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_confirm:
                presenter.saveUserDatas();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_user_info);
        presenter = new UserInfoPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initUserDatas();      //  初始化用户信息
    }

    @Override
    public void initUserDatas(UserInfoModel model) {
        mName.setText(model.getNickname());
        if (model.getSex().equals("男")) {
            mMan.setChecked(true);
        }else if (model.getSex().equals("女")) {
            mWoman.setChecked(true);
        }
        mBirthday.setText(model.getBirthdate());
        mStature.setText(model.getHeight());
        mWeight.setText(model.getWeight());
    }

    @Override
    public String getName() {
        return mName.getText().toString();
    }

    @Override
    public String getSex() {
        if (mMan.isChecked()) {
            return "男";
        }else {
            return "女";
        }
    }

    @Override
    public String getBirthday() {
        return mBirthday.getText().toString();
    }

    @Override
    public String getStature() {
        return mStature.getText().toString();
    }

    @Override
    public String getWeight() {
        return mWeight.getText().toString();
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }

}
