package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shaoyuan.model.dataInfo.ScreenInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/29 9:44
 * title：健康体检列表适配器
 */
public class ScreenAdapter extends BaseRecyclerAdapter<ScreenInfo> {

    private Context context;

    public ScreenAdapter(Context mContext, List<ScreenInfo> mList) {
        super(mContext, mList);
        this.context = mContext;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_screen_item;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, ScreenInfo bean, int position) {
        RelativeLayout mItem = holder.getItemView(R.id.rl_screen_item);

        ImageView mImage = holder.getItemView(R.id.iv_img);
        TextView mTitle = holder.getItemView(R.id.tv_title);
        TextView mContext = holder.getItemView(R.id.tv_context);
        TextView mCurrent = holder.getItemView(R.id.tv_current_price);
        TextView mOriginal = holder.getItemView(R.id.tv_original_price);


        Glide.with(context).load("").into(mImage);
        mTitle.setText("");
        mContext.setText("");
        mCurrent.setText("");
        mOriginal.setText("");

        mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
