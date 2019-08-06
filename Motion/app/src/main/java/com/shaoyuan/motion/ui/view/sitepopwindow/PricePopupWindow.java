package com.shaoyuan.motion.ui.view.sitepopwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.shaoyuan.motion.R;

/**
 * Created by gzl on 2019/8/1 10:09
 * title：价格筛选
 */
public class PricePopupWindow extends ZPopupWindow implements ZPopupWindow.OnDismissListener{
    public PricePopupWindow(Context context) {
        super(context);
    }

    @Override
    public void onDismiss() {

    }

    @Override
    protected View generateCustomView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.popwindow_user, null, false);
        return inflate;
    }
}
