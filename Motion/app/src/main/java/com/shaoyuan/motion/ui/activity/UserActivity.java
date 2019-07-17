package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.UserInfoInterface;
import com.shaoyuan.core.persenter.UserInfoPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class UserActivity extends BaseActivity implements UserInfoInterface.view,RadioGroup.OnCheckedChangeListener {
    private static final String Tag = "UserActivity";
    private UserInfoPresenter presenter;

    @BindView(R.id.tv_back_title) TextView mTitle;
    @BindView(R.id.tv_name)TextView mName;
    @BindView(R.id.rg_sex)RadioGroup mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText(R.string.tv_mine_user_info);
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
        presenter = new UserInfoPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initUserDatas();      //  初始化用户信息
    }

    @Override
    public void initUserDatas(UserInfoModel model) {
        mName.setText(model.getNickname());
        mSex.setOnCheckedChangeListener(this);
    }

    /** 用户详情参数 */
    @Override
    public Map<String, Object> params() {
        return null;
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }

    @OnClick({R.id.rb_man,R.id.rb_woman})
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_man:

                break;
            case R.id.rb_woman:

                break;
        }
    }
}
