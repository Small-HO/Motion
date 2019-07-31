package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shaoyuan.model.dataInfo.IllnessInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/29 16:15
 * title：高发疾病多选适配
 */
public class IllnessAdapter extends BaseRecyclerAdapter<IllnessInfo>{

    private Context context;
    private List<IllnessInfo> list;

    public IllnessAdapter(Context mContext, List<IllnessInfo> mList) {
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
                if (list.get(position).isSelect()) {
                    item.setBackgroundResource(R.drawable.radiobutton_background_unchecked);
                    item.setTextColor(context.getResources().getColor(R.color.colorMineText));
                    list.get(position).setSelect(false);
                }else {
                    item.setBackgroundResource(R.drawable.radiobutton_background_checked);
                    item.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    list.get(position).setSelect(true);
                }
            }
        });
    }
}
