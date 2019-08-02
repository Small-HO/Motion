package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.BookingOrderInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;

/**
 * Created by small-ho on 2019/8/2 16:59
 * title：预约订单核心逻辑
 */
public class BookingOrderPresenter implements BookingOrderInterface.presenter {

    private BookingOrderInterface.view view;
    private AppAction action;

    public BookingOrderPresenter(BookingOrderInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initCommodityData() {
        view.initCommodityData();
    }

    @Override
    public void submit() {
    }
}
