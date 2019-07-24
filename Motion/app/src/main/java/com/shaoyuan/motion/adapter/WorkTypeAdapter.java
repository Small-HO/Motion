package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.model.dataInfo.WorkInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/24 11:13
 * title：工作左侧类型适配
 */
public class WorkTypeAdapter extends BaseRecyclerAdapter<WorkInfo> {

    public WorkTypeAdapter(Context mContext, List<WorkInfo> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_data_module_work_left;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, WorkInfo bean, int position) {
        TextView mItem = holder.getItemView(R.id.tv_work_left_item);
        mItem.setText(bean.getTypenamee());
        mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
