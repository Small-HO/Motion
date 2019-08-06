package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.model.dierbanBean.SiteScreenBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by gzl on 2019/8/1 15:38
 * title：器械筛选适配器
 */
public class EquipmentPopAdapter extends BaseRecyclerAdapter<SiteScreenBean> {

    Context context;
    List<SiteScreenBean> list;
    public EquipmentPopAdapter(Context mContext, List<SiteScreenBean> mList) {
        super(mContext, mList);
        this.context=mContext;
        this.list=mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.popwindow_site;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, SiteScreenBean bean, int position) {

        TextView tv_pop_title = holder.getItemView(R.id.tv_pop_title);
        TextView tv_pop_xian = holder.getItemView(R.id.tv_pop_xian);
        TextView tv_pop_dui = holder.getItemView(R.id.tv_pop_dui);
        String s = bean.getEquipment().get(position);
        tv_pop_title.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickListener.onItemClick(position);
            }
        });
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
