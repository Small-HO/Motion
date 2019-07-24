package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.WorkInterface;
import com.shaoyuan.core.persenter.WorkPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.WorkModel;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.WorkTypeAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkActivity extends BaseActivity implements WorkInterface.view,TextView.OnEditorActionListener{
    private static final String Tag = "WorkActivity";
    private WorkPresenter presenter;

    @BindView(R.id.et_search)EditText mSearch;
    @BindView(R.id.recycler_view)RecyclerView mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work;
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
        presenter = new WorkPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initClassItem();      //  初始化工作左侧分类列表
        presenter.initContextItem();    //  初始化工作右侧内容
    }

    @Override
    public String getSearchText() {
        return mSearch.getText().toString();
    }

    /** 左侧工作类型导航栏 */
    @Override
    public void initClassItem(WorkModel model) {
        mItem.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mItem.setAdapter(new WorkTypeAdapter(this,model.getGetdata()));
    }

    /** 右侧具体内容 */
    @Override
    public void initContextItem(WorkModel model) {

    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }

    /** 搜索部分 */
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_SEARCH) {
            //  隐藏软键盘
            if (TextUtils.isEmpty(textView.getText().toString())) {

            }
        }
        return false;
    }

}
