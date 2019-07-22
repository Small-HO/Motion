package com.shaoyuan.motion.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class DietActivity extends BaseActivity {

    @BindView(R.id.tv_back_title)TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText("摄入");
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
        return R.layout.activity_diet;
    }
}
