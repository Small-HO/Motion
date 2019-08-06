package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.TextView;

import com.shaoyuan.model.dierbanBean.CoachBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by gzl on 2019/8/6 14:26
 * title：标签适配器
 */
public class CoachLabelAdapter extends BaseRecyclerAdapter<CoachBean.CoachlistBean> {

    Context context;
    List<CoachBean.CoachlistBean> list;

    public CoachLabelAdapter(Context mContext, List<CoachBean.CoachlistBean> mList) {
        super(mContext, mList);
        this.list=mList;
        this.context=mContext;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_label;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, CoachBean.CoachlistBean bean, int position) {
        TextView tv_label = holder.getItemView(R.id.tv_label);
        String s = bean.getLable().get(position);
        tv_label.setText(s);
    }

}
