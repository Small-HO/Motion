package com.shaoyuan.motion.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.ConsumeInterface;
import com.shaoyuan.core.persenter.ConsumePersenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.ConsumeAdapter;
import com.shaoyuan.motion.ui.view.CircleAnnular;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsumeFragment extends BaseFragment implements ConsumeInterface.view {
    private static final String Tag = "ConsumeFragment";
    private ConsumePersenter persenter;
    @BindView(R.id.annularChartView)CircleAnnular mPas;

    @BindView(R.id.tv_work)TextView mWork;
    @BindView(R.id.tv_sleep)TextView mSleep;
    @BindView(R.id.tv_motion)TextView mMotion;
    @BindView(R.id.tv_fashion)TextView mFashion;

    @BindView(R.id.recycler_view)RecyclerView mSchedule;

    public ConsumeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_consume;
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {
        persenter = new ConsumePersenter(this);
        persenter.initConsumeDatas();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            persenter.initConsumeDatas();
        }
    }

    @Override
    public void initConsumeDatas(DataReportModel model) {
        //  模拟数据
        mWork.setText("25%");
        mSleep.setText("25%");
        mMotion.setText("25%");
        mFashion.setText("25%");
        mPas.setData(new float[]{25,25,25,25,2f});

        mSchedule.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mSchedule.setAdapter(new ConsumeAdapter(getContext(),model.getGetdata()));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
