package com.shaoyuan.motion.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DataFragment extends BaseFragment {

    @BindView(R.id.tv_title)TextView mTitle;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_data;
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {
        mTitle.setText(R.string.tv_tab_data_title);
    }

}