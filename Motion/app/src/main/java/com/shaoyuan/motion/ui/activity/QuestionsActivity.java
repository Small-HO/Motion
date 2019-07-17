package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.QuestionsInterface;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;

public class QuestionsActivity extends BaseActivity implements QuestionsInterface.view {
    private static final String Tag = "QuestionsActivity";

    @BindView(R.id.tv_back_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText(R.string.tv_mine_module_faq);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questions;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {

    }
}
