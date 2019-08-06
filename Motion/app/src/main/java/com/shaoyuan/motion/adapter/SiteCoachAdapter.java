package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.shaoyuan.model.dierbanBean.SiteDetailBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by gzl on 2019/8/2 14:00
 * title：
 */
public class SiteCoachAdapter extends BaseRecyclerAdapter<SiteDetailBean.CoachinfoBean> {

    Context context;
    List<SiteDetailBean.CoachinfoBean> list;

    public SiteCoachAdapter(Context mContext, List<SiteDetailBean.CoachinfoBean> mList) {
        super(mContext, mList);
        this.context=mContext;
        this.list=mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_site_coach;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, SiteDetailBean.CoachinfoBean bean, int position) {
        ImageView img_coach = holder.getItemView(R.id.img_coach);
        TextView tv_coach_name = holder.getItemView(R.id.tv_coach_name);
        TextView tv_coach_title = holder.getItemView(R.id.tv_coach_title);
        TextView tv_coach_num = holder.getItemView(R.id.tv_coach_num);
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(true);
        Glide.with(context).load(bean.getCoachpic()).apply(options).into(img_coach);

        tv_coach_name.setText(bean.getCoachname());
        tv_coach_title.setText(bean.getLabel().get(0));
        tv_coach_num.setText("累计上课"+bean.getTimes()+"节");

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
