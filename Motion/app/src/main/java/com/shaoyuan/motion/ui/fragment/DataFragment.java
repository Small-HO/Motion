package com.shaoyuan.motion.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.DataInterface;
import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.activity.IntakeActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends BaseFragment implements DataInterface.view {

    @BindView(R.id.tv_title)TextView mTitle;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_data;
    }

    @OnClick({R.id.tv_module_intake,R.id.tv_module_exercise,R.id.tv_module_stamina,R.id.tv_module_constitution})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_module_intake:
                toIntakePage();
                break;
            case R.id.tv_module_exercise:

                break;
            case R.id.tv_module_stamina:

                break;
            case R.id.tv_module_constitution:

                break;
        }
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {
        mTitle.setText(R.string.tv_tab_data_title);
    }

    @Override
    public void toIntakePage() {
        startActivity(new Intent(getContext(), IntakeActivity.class));
    }
}
