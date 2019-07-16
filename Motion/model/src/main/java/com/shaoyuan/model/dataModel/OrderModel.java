package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.dataInfo.OrderInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by small-ho on 2019/7/16 11:01
 * title：订单列表数据模型
 */
public class OrderModel extends BaseModel implements Serializable {
    private List<OrderInfo> orderInfos;

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(List<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
    }
}
