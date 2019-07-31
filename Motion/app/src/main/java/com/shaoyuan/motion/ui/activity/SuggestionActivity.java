package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SuggestionInterface;
import com.shaoyuan.core.persenter.SuggestionPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.personalBean.FeedbackBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SuggestionActivity extends BaseActivity implements SuggestionInterface.view,TextWatcher{
    private static final String Tag = "SuggestionActivity";
    private SuggestionPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.et_suggestion)EditText mContont;
    @BindView(R.id.tv_num)TextView mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @OnClick({R.id.iv_back,R.id.tv_ok})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_ok:
                presenter.submit();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_suggestion;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_mine_module_feedback);
        mContont.addTextChangedListener(this);
        presenter = new SuggestionPresenter(this);
    }

    @Override
    public void initFeedback(FeedbackBean feedbackBean) {
        if(feedbackBean.getRepcode().equals("00")){

        }
    }

    @Override
    public String getText() {
        return mContont.getText().toString();
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        mNum.setText(editable.length() + "/500");
    }
}
