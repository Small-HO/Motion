package com.shaoyuan.core.persenter;

import android.view.View;

import com.shaoyuan.core.Interfaces.PlasticSurgeryInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by small-ho on 2019/7/31 17:56
 * title：体检详情核心逻辑
 */
public class PlasticSurgeryPresenter implements PlasticSurgeryInterface.presenter {
    private PlasticSurgeryInterface.view view;
    private AppAction action;

    public PlasticSurgeryPresenter(PlasticSurgeryInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }


    @Override
    public void initPlasticSurgeryData() {
        action.physicalDetails(params(), new HttpCallback<PhysicalDetailsBean>() {
            @Override
            public void onSuccesss(PhysicalDetailsBean result) {
                view.showLog("体检详情数据：" + result);
                if (result.getRepcode().equals("00")) {
                    view.initPlasticSurgeryData(result);        //  显示数据
                }
            }
        });
    }

    private Map<String, Object> params() {
        Map<String,Object> params = new HashMap<>();
        params.put("method","getexamination");
        params.put("setmealid",view.initInterData());
        view.showLog("测试参数：" + params);
        return params;
    }
}
