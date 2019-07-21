package com.shaoyuan.motion.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;

public class ConsumeActivity extends BaseActivity {

    @BindView(R.id.tv_back_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText("消耗");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_consume;
    }
}
