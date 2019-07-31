package com.shaoyuan.motion.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by small-ho on 2019/7/15 10:08
 * title：封装RecyclerView
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context mContext;
    private List<T> mList;
    private LayoutInflater inflater;

    public BaseRecyclerAdapter(Context mContext, List<T> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(getLayoutResId(),parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemView.setTag(position);
        T bean = mList.get(position);
        onBindViewHolder(holder,bean,position);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    /** 获取布局 */
    protected abstract int getLayoutResId();


    protected abstract void onBindViewHolder(RecyclerViewHolder holder,T bean,int position);
}
