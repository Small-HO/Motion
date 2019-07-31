package com.shaoyuan.core.Interfaces;


import android.content.Context;

/**
 * Created by small-ho on 2019/7/31 8:55
 * title：体检中心核心接口
 */
public interface PlasticSurgeryInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        void toOrderPage();

        void showLog(String log);
    }

    interface presenter {

    }
}
