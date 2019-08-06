package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shaoyuan.model.dierbanBean.CoachBean;
import com.shaoyuan.motion.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzl on 2019/8/6 14:19
 * title：教练列表适配器
 */
public class CoachAdapter extends BaseRecyclerAdapter<CoachBean.CoachlistBean> {

    Context context;
    List<CoachBean.CoachlistBean> list;

    public CoachAdapter(Context mContext, List<CoachBean.CoachlistBean> mList) {
        super(mContext, mList);
        this.context=mContext;
        this.list=mList;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_coach;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, CoachBean.CoachlistBean bean, int position) {
        TextView tv_item_name = holder.getItemView(R.id.tv_item_name);
        ImageView img_item_coach = holder.getItemView(R.id.img_item_coach);
        TextView tv_item_comment = holder.getItemView(R.id.tv_item_comment);
        TextView tv_item_coursecount = holder.getItemView(R.id.tv_item_coursecount);
        TextView tv_item_price = holder.getItemView(R.id.tv_item_price);
        RecyclerView rec_item_coach = holder.getItemView(R.id.rec_item_coach);

        Glide.with(context).load(bean.getPic()).into(img_item_coach);
        tv_item_name.setText(bean.getName());
        tv_item_price.setText("¥"+bean.getLowest()+"/课时起");
        tv_item_comment.setText("好评度"+bean.getComment());
        tv_item_coursecount.setText("累计上课"+bean.getCoursecount()+"节");

        List<String> lable = bean.getLable();
        List<CoachBean.CoachlistBean> lists=new ArrayList<>();
        for (int i = 0; i < lable.size(); i++) {
            CoachBean.CoachlistBean coachBean=new CoachBean.CoachlistBean();
            coachBean.setLable(lable);
            lists.add(coachBean);
        }
        CoachLabelAdapter coachAdapter=new CoachLabelAdapter(context,lists);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rec_item_coach.setLayoutManager(manager);
        rec_item_coach.setAdapter(coachAdapter);

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

