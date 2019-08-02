package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/8/2 16:29
 * title：预约订单核心接口
 */
public interface BookingOrderInterface {

    interface view {
        Context getContext();

        void initView();
        void initData();

        void initCommodityData();

        void showLog(String log);
    }

    interface presenter {

        void initCommodityData();

        void submit();
    }
}
