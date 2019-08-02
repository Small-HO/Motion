package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.TextView;

import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/8/2 11:19
 * title：体检中心标签
 */
public class LabelAdapter extends BaseRecyclerAdapter<PhysicalDetailsBean.DiseaseBean> {

    public LabelAdapter(Context mContext, List<PhysicalDetailsBean.DiseaseBean> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_label;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, PhysicalDetailsBean.DiseaseBean bean, int position) {
        TextView label = holder.getItemView(R.id.tv_label);

        label.setText(bean.getDisname());
    }
}
