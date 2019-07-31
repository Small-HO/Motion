package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shaoyuan.model.dataInfo.OrderInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/15 9:39
 * title：订单列表适配器
 */
public class OrderAdapter extends BaseRecyclerAdapter<OrderInfo>{

    public OrderAdapter(Context mContext, List<OrderInfo> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_mine_module_order;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, OrderInfo bean, int position) {
        RelativeLayout mItem = holder.getItemView(R.id.order_list_item);
        ImageView mImage = holder.getItemView(R.id.iv_order_image);
        TextView mName = holder.getItemView(R.id.tv_name);
        TextView mMoney = holder.getItemView(R.id.tv_money);
        TextView mExplain = holder.getItemView(R.id.tv_explain);
        TextView mTime = holder.getItemView(R.id.tv_time);
        TextView mStart = holder.getItemView(R.id.tv_order_start);

        mName.setText(bean.getMechname());
        mMoney.setText(bean.getSetmealprice());
        mExplain.setText(bean.getTemstype());
        mTime.setText(bean.getCreattime());
        if (bean.isPaystate()) {
            mStart.setText("已付款");
        }else {
            mStart.setText("未付款");
        }
    }

}
