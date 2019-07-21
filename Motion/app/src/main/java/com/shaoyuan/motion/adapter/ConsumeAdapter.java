package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.TextView;

import com.shaoyuan.model.dataInfo.DataReportInfo;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.view.ProgressView;

import java.util.List;

/**
 * Created by small-ho on 2019/7/20 11:03
 * title：报告分析适配器
 */
public class ConsumeAdapter extends BaseRecyclerAdapter<DataReportInfo> {

    public ConsumeAdapter(Context mContext, List<DataReportInfo> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_item_health_data;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, DataReportInfo bean) {
        TextView name = holder.getItemView(R.id.tv_name);
        ProgressView pv = holder.getItemView(R.id.progress_view);
        TextView percent = holder.getItemView(R.id.tv_percent);

        name.setText(bean.getConmany());
        pv.setMaxCount(24);
        pv.setColor("#82B8FF");
        pv.setCurrentCount(60);
    }
}
