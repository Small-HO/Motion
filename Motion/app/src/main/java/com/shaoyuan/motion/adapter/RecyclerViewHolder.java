package com.shaoyuan.motion.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by small-ho on 2019/7/15 10:08
 * title：封装ViewHolder
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mView;    //  用来保存所有的ItemView集合

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.mView = new SparseArray<>();
    }

    public <T extends View> T getItemView(int id) {
        View view = mView.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mView.put(id,view);
        }
        return (T) view;
    }
}
