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
public class IntakeFragment extends BaseFragment implements ConsumeInterface.view{
    private static final String Tag = "IntakeFragment";
    private ConsumePersenter persenter;
    @BindView(R.id.annularChartView)CircleAnnular mPas;

    @BindView(R.id.tv_brekker)TextView mBrekker;
    @BindView(R.id.tv_lunch)TextView mLunch;
    @BindView(R.id.tv_supper)TextView mSupper;
    @BindView(R.id.tv_snacks)TextView mSnacks;

    @BindView(R.id.recycler_view)RecyclerView mSchedule;

    public IntakeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_intake;
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
        mBrekker.setText("25%");
        mLunch.setText("25%");
        mSupper.setText("25%");
        mSnacks.setText("25%");
        mPas.setData(new float[]{25,25,25,25,2f});

        mSchedule.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mSchedule.setAdapter(new ConsumeAdapter(getContext(),model.getGetdata()));
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
