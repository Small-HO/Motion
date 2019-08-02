package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.shaoyuan.model.dierbanBean.SiteDetailBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by gzl on 2019/8/2 13:54
 * title：场地详情器械列表适配器
 */
public class SiteApparatusAdapter extends BaseRecyclerAdapter<SiteDetailBean.ApparlistBean> {

    Context context;
    List<SiteDetailBean.ApparlistBean> list;

    public SiteApparatusAdapter(Context mContext, List<SiteDetailBean.ApparlistBean> mList) {
        super(mContext, mList);
        this.context=mContext;
        this.list=mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_site_apparatus;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, SiteDetailBean.ApparlistBean bean, int position) {
        ImageView img_apparatus = holder.getItemView(R.id.img_apparatus);
        TextView tv_apparatus = holder.getItemView(R.id.tv_apparatus);

        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(20));
        Glide.with(context).load(bean.getEquipic())
                .apply(options)
                .into(img_apparatus);
        tv_apparatus.setText(bean.getEquipname());

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
