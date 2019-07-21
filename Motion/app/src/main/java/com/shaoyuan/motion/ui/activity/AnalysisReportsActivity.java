package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.AnalysisReportsInterface;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.fragment.ConsumeFragment;
import com.shaoyuan.motion.ui.fragment.IntakeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AnalysisReportsActivity extends BaseActivity implements AnalysisReportsInterface.view {

    @BindView(R.id.tv_back_title)TextView mTitle;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        addFragment(savedInstanceState);
    }

    @OnClick({R.id.iv_back,R.id.tv_xiaohao,R.id.tv_sheru})
    public void onClick(View view) {
        int index = 0;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_xiaohao:
                index = 0;
                break;
            case R.id.tv_sheru:
                index = 1;
                break;
        }
        switchFragment(index);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_analysis_reports;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_data_trend_reporter);
    }

    private void addFragment(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (savedInstanceState == null) {
            fragments.add(new ConsumeFragment());
            fragments.add(new IntakeFragment());

            int index = 0;
            for (Fragment f :fragments) {
                transaction.add(R.id.fragment,f,"tag" + index);
                transaction.hide(f);
                index ++;
            }
            transaction.show(fragments.get(0));
            transaction.commit();
        }else {
            for (int i = 0; i < fragments.size(); i++) {
                String tag = "tag" + i;
                Fragment f = manager.findFragmentByTag(tag);
                if (f != null) {
                    fragments.add(f);
                }
            }
        }
    }

    private void switchFragment(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (index >= 0 && index < fragments.size()) {
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                if (i == index){
                    transaction.show(fragment);
                }else {
                    transaction.hide(fragment);
                }
            }
            transaction.commit();
        }
    }
}
