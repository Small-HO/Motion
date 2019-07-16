package com.shaoyuan.core.Interfaces;

import android.content.Context;
import com.shaoyuan.model.dataModel.OrderModel;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/16 9:09
 * title：订单列表核心类
 */
public interface OrderInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        void initOrderDatas(OrderModel model);

        Map<String,Object> orderParams();

        void showLog(String log);
    }

    interface presenter {
        void initOrderDatas();
    }
}
