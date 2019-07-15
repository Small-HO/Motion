package com.shaoyuan.motion.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RecipeActivity extends BaseActivity {

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.tv_recipe_grade)TextView mGrade;
    @BindView(R.id.tv_upgrade_recipe)TextView mUpgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText(R.string.tv_home_module_recipe);
        mGrade.setText(R.string.tv_recipe_grade);
        mUpgrade.setText(R.string.tv_mUpgrade_recipe);
    }

    @OnClick({R.id.iv_back,R.id.tv_upgrade_recipe,R.id.tv_to_motion})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_upgrade_recipe:

                break;
            case R.id.tv_to_motion:

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recipe;
    }
}
