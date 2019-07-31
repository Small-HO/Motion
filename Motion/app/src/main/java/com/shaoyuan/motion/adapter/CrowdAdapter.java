package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shaoyuan.model.dataInfo.IllnessInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/29 16:05
 * title：适用人群适配器
 */
public class CrowdAdapter extends BaseRecyclerAdapter<IllnessInfo> {

    private Context context;
    private List<IllnessInfo> list;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CrowdAdapter(Context mContext, List<IllnessInfo> mList) {
        super(mContext, mList);
        this.context = mContext;
        this.list = mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_select;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, IllnessInfo bean, final int position) {
        RelativeLayout items = holder.getItemView(R.id.rl_select_item);
        final TextView item = holder.getItemView(R.id.tv_select_item);

        item.setText(bean.getItem());
        items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setBackgroundResource(R.drawable.radiobutton_background_checked);
                item.setTextColor(context.getResources().getColor(R.color.colorWhite));
                onItemClickListener.onItemClick(position);
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
