package com.shaoyuan.core.persenter;

import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.BookingOrderInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.core.utils.SharedPreferencesUtils;
import com.shaoyuan.model.personalBean.MakeAnPhysicalBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

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
        view.showPayDialog();
        action.makeAnPhysical(params(), new HttpCallback<MakeAnPhysicalBean>() {
            @Override
            public void onSuccesss(MakeAnPhysicalBean result) {
                view.showLog("提交预约订单：" + result.toString());
                if (result.getRepcode().equals("00")) {
                    SharedPreferencesUtils.saveString(view.getContext(), Constants.recordid,result.getRecordid());
                }
            }

            @Override
            public void onFailures(String erro) {
                view.showToast(erro);
            }
        });
    }

    private Map<String, Object> params() {
        Map<String,Object> params = new HashMap<>();
        params.put("method","upexamination");
        params.put("userid","15641307846793458");
        params.put("physicalid", view.getID());     //  套餐ID
        params.put("username",view.getName());      //  真实姓名
        params.put("sex",view.getSex());            //  性别
        params.put("usercard",view.getCard());      //  身份证
        params.put("phone",view.getPhone());        //  手机号
        params.put("apptime",view.getTime());       //  预约时间
        params.put("remarks",view.getRemark());     //  备注
        params.put("price",view.getPrice());        //  价格
        view.showLog("测试参数：" + params);
        return params;
    }
}
