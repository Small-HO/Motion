package com.shaoyuan.motion.ui.view.sitepopwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.shaoyuan.motion.R;

public class UserPopupWindow extends ZPopupWindow implements ZPopupWindow.OnDismissListener{
    public UserPopupWindow(Context context) {
        super(context);
    }

    @Override
    public void onDismiss() {

    }

    @Override
    protected View generateCustomView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.popwindow_user,null,false);
    }
}
