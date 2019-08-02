package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.ImageLoader;

import java.util.List;

/**
 * Created by small-ho on 2019/8/2 13:41
 * title：套餐特点适配
 */
public class TraitAdapter extends BaseRecyclerAdapter<PhysicalDetailsBean.DiseaseBean>{

    private Context context;

    public TraitAdapter(Context mContext, List<PhysicalDetailsBean.DiseaseBean> mList) {
        super(mContext, mList);
        this.context = mContext;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_home_module_trait;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, PhysicalDetailsBean.DiseaseBean bean, int position) {
        ImageView image = holder.getItemView(R.id.iv_image);
        TextView mTrait = holder.getItemView(R.id.tv_trait);
        mTrait.setText(bean.getDisname());
        ImageLoader.image(context,bean.getDispic(),image);
    }
}
