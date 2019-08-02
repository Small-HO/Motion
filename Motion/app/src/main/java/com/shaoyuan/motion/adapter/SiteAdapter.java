package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shaoyuan.api.Constants;
import com.shaoyuan.core.utils.Utils;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by gzl on 2019/8/1 13:40
 * title：
 */
public class SiteAdapter extends BaseRecyclerAdapter<SiteBean.DataBean> {

    Context context;
    List<SiteBean.DataBean> list;

    public SiteAdapter(Context mContext, List<SiteBean.DataBean> mList ) {
        super(mContext, mList);
        this.context = mContext;
        this.list = mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_site;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, SiteBean.DataBean bean, int position) {
        ImageView img_user_site = holder.getItemView(R.id.img_user_site);
        TextView tv_title_site = holder.getItemView(R.id.tv_title_site);
        TextView tv_name_site = holder.getItemView(R.id.tv_name_site);
        TextView tv_distance_site = holder.getItemView(R.id.tv_distance_site);
        TextView tv_price_site = holder.getItemView(R.id.tv_price_site);

        Glide.with(context).load(bean.getPic()).into(img_user_site);
        tv_title_site.setText(bean.getMachname());
        tv_name_site.setText(bean.getArea());
        //维度
        String lat = bean.getLat();
        //经度
        String lng = bean.getLng();
        double distance = Utils.DistanceOfTwoPoints(Constants.WEIDU, Constants.JINDDU, Double.parseDouble(lat), Double.parseDouble(lng));
        tv_distance_site.setText("距您"+distance+"公里");
        tv_price_site.setText(bean.getPrice());

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
