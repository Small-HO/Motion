package com.shaoyuan.motion.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;

public class PlanActivity extends BaseActivity {

    @BindView(R.id.tv_back_title) TextView mTitle;
    @BindView(R.id.tv_recipe_grade)TextView mGrade;
    @BindView(R.id.tv_upgrade_recipe)TextView mUpgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText(R.string.tv_home_module_plan);
        mGrade.setText(R.string.tv_sports_days);
        mUpgrade.setText(R.string.tv_mUpgrade_recipe);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plan;
    }
}
