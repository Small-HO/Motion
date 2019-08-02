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
 * Created by gzl on 2019/8/2 13:50
 * title：场地详情功能列表适配器
 */
public class SiteFunctionAdapter extends BaseRecyclerAdapter<SiteDetailBean.FuncintroBean>{

    Context context;
    List<SiteDetailBean.FuncintroBean> list;

    public SiteFunctionAdapter(Context mContext, List<SiteDetailBean.FuncintroBean> mList) {
        super(mContext, mList);
        this.context=mContext;
        this.list=mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_site_function;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, SiteDetailBean.FuncintroBean bean, int position) {
        ImageView img_function = holder.getItemView(R.id.img_function);
        TextView tv_function = holder.getItemView(R.id.tv_function);

        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(20));
        Glide.with(context).load(bean.getAreapic())
                .apply(options)
                .into(img_function);
        tv_function.setText(bean.getAreaname());

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
