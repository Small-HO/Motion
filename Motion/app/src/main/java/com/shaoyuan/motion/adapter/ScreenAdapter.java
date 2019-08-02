package com.shaoyuan.motion.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shaoyuan.model.personalBean.PhysicalListBean;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.ImageLoader;

import java.util.List;

/**
 * Created by small-ho on 2019/7/29 9:44
 * title：健康体检列表适配器
 */
public class ScreenAdapter extends BaseRecyclerAdapter<PhysicalListBean.PhysicallistBean> {

    private Context context;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ScreenAdapter(Context mContext, List<PhysicalListBean.PhysicallistBean> mList) {
        super(mContext, mList);
        this.context = mContext;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_screen_item;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, PhysicalListBean.PhysicallistBean bean, final int position) {
        RelativeLayout mItem = holder.getItemView(R.id.rl_screen_item);

        ImageView mImage = holder.getItemView(R.id.iv_img);
        TextView mTitle = holder.getItemView(R.id.tv_title);
        TextView mContext = holder.getItemView(R.id.tv_context);
        TextView mCurrent = holder.getItemView(R.id.tv_current_price);
        TextView mOriginal = holder.getItemView(R.id.tv_original_price);

        mOriginal.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        Glide.with(context).load(bean.getSetmealpic()).into(mImage);
        ImageLoader.displayImage(context,bean.getSetmealpic(),mImage);
        mTitle.setText(bean.getSetmealname());
        mContext.setText(bean.getMechaddress());
        mCurrent.setText("￥" + bean.getSetmealprice());
        mOriginal.setText(bean.getSetmealprices());

        mItem.setOnClickListener(v -> onItemClickListener.onItemClick(position));
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
