package com.shaoyuan.core.Interfaces;

import android.content.Context;


/**
 * Created by small-ho on 2019/8/6 15:04
 * title：支付核心接口
 */
public interface PayInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        String getAppid();

        void showLog(String log);
    }

    interface presenter {
        void alipay();
        void wxpay();
        void pay();
    }
}
