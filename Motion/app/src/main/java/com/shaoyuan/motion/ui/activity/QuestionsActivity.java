package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.QuestionsInterface;
import com.shaoyuan.core.persenter.QuestionsPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.QuestionsAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class QuestionsActivity extends BaseActivity implements QuestionsInterface.view {
    private static final String Tag = "QuestionsActivity";
    private QuestionsPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.recycler_view)RecyclerView mQuestions;

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
        return R.layout.activity_questions;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_module_faq);
        presenter = new QuestionsPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initQuestionDatas();  //  初始化常见问题数据
    }

    @Override
    public void initQuestionDatas(QuestionModel model) {
        mQuestions.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mQuestions.setAdapter(new QuestionsAdapter(this,model.getInfos()));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
