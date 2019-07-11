package com.shaoyuan.motion.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.shaoyuan.motion.R;

/**
 * Created by small-ho on 2019/7/11 17:57
 * title：自定义加载页面
 */
public class LoadDialog extends Dialog {
    private OnSelectedListener listener;
    Context context;

    public LoadDialog(Context context) {
        super(context, R.style.alert_dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_no_data_layout);
        //设置显示dialog后,触屏屏幕不会使dialog消失
        setCanceledOnTouchOutside(false);
    }

    public interface OnSelectedListener {
        void getData(String time);

    }

    public void setOnSelectedListener(OnSelectedListener listener) {
        this.listener = listener;
    }
}
