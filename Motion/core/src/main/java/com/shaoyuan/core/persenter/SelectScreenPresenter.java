package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.SelectScreenInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.IllnessModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/29 15:49
 * title：选择体检项目核心逻辑
 */
public class SelectScreenPresenter implements SelectScreenInterface.presenter {
    private SelectScreenInterface.view view;
    private AppAction action;

    public SelectScreenPresenter(SelectScreenInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initCrowdData() {
//        action.crowdList(crowdParams(), new HttpCallback<IllnessModel>() {
//            @Override
//            public void onSuccess(IllnessModel model) {
//                view.showLog("使用人群返回数据：" + model);
//                view.initCrowdData(model);
//            }
//
//            @Override
//            public void onFailure(String e) {
//
//            }
//        });
    }

    @Override
    public void initIllnessData() {
//        action.illnessList(illnessParams(), new HttpCallback<IllnessModel>() {
//            @Override
//            public void onSuccess(IllnessModel model) {
//                view.showLog("高发疾病返回数据：" + model);
//                view.initIllnessData(model);
//            }
//
//            @Override
//            public void onFailure(String e) {
//
//            }
//        });
    }

    @Override
    public void submit() {

    }

    private Map<String, Object> illnessParams() {
        return null;
    }

    private Map<String, Object> crowdParams() {
        return null;
    }
}
