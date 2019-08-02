package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/8/2 14:54
 * title：体检内容适配
 */
public class InspectAdapter extends BaseRecyclerAdapter<PhysicalDetailsBean.MinationlistBean> {

    public InspectAdapter(Context mContext, List<PhysicalDetailsBean.MinationlistBean> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_context;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, PhysicalDetailsBean.MinationlistBean bean, int position) {
        TextView mTitle = holder.getItemView(R.id.tv_inspect_title);
        ImageView mImag = holder.getItemView(R.id.iv_image);
        TextView mContext = holder.getItemView(R.id.tv_content);
        TextView mDisease = holder.getItemView(R.id.tv_disease);

        mTitle.setText(bean.getDetectionname());
        mContext.setText(bean.getInspectcontent());
        mDisease.setText(bean.getInspectgoal());
    }
}
