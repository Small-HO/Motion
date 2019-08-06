package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.OrderInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/16 9:08
 * title：订单列表核心逻辑
 */
public class OrderPresenter implements OrderInterface.presenter {
    private OrderInterface.view view;
    private AppAction action;

    public OrderPresenter(OrderInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initOrderDatas() {
        /*action.orderInfo(orderParams(), new HttpCallback<OrderModel>() {
            @Override
            public void onSuccess(OrderModel model) {
                view.showLog("订单列表请求状态：" + model.getOrderInfos().toString());
                view.initOrderDatas(model);
            }

            @Override
            public void onFailure(String e) {

            }
        });*/
    }

    private Map<String, Object> orderParams() {
        return null;
    }
}
