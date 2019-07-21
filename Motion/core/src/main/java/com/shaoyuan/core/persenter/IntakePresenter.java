package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.IntakeInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/19 14:07
 * title：消耗摄入核心逻辑
 */
public class IntakePresenter implements IntakeInterface.presenter {
    private IntakeInterface.view view;
    private AppAction action;

    public IntakePresenter(IntakeInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }


    @Override
    public void initCountcontodyData() {
        action.countconTody(params(), new HttpCallback<CountcontodayModel>() {
            @Override
            public void onSuccess(CountcontodayModel model) {
                view.showLog("消耗摄入：" + model.toString());
                view.initCountcontodyData(model);
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }

    private Map<String, Object> params() {
        return null;
    }
}