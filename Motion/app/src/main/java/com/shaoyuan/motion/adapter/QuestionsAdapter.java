package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.widget.TextView;

import com.shaoyuan.model.dataInfo.QuestionInfo;
import com.shaoyuan.motion.R;

import java.util.List;

/**
 * Created by small-ho on 2019/7/18 8:42
 * title：常见问题适配器
 */
public class QuestionsAdapter extends BaseRecyclerAdapter<QuestionInfo> {

    public QuestionsAdapter(Context mContext, List<QuestionInfo> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ui_mine_question;
    }

    @Override
    protected void onBindViewHolder(RecyclerViewHolder holder, QuestionInfo bean) {
        TextView headline = holder.getItemView(R.id.tv_headline);
        TextView contont = holder.getItemView(R.id.tv_contont);

        headline.setText(bean.getComname());
        contont.setText(bean.getSpoexpain());
    }
}
