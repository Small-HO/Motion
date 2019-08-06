package com.shaoyuan.motion.ui.view.sitepopwindow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.shaoyuan.motion.R;

/**
 * Created by gzl on 2019/8/1 10:12
 * title：距离排序
 */
public class DistancePopupWindow extends ZPopupWindow implements ZPopupWindow.OnDismissListener{

    private RecyclerView rec_user_screen;

    public DistancePopupWindow(Context context) {
        super(context);
    }

    @Override
    public void onDismiss() {

    }

    @Override
    protected View generateCustomView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.popwindow_user, null, false);
        rec_user_screen = inflate.findViewById(R.id.rec_user_screen);
        return inflate;
    }

    private void initData(){

    }
}
