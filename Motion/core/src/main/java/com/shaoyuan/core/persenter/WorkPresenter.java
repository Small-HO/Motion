package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.WorkInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/23 18:08
 * title：工作核心逻辑
 */
public class WorkPresenter implements WorkInterface.presenter {
    private WorkInterface.view view;
    private AppAction action;

    public WorkPresenter(WorkInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initClassItem() {
       /* action.addWorkConsume(classItemParams(), new HttpCallback<WorkModel>() {
            @Override
            public void onSuccess(WorkModel model) {
                view.showLog("添加工作左侧分类数据：" + model.toString());
                view.initClassItem(model);
            }

            @Override
            public void onFailure(String e) {

            }*/
       // });
    }

    @Override
    public void initContextItem() {
        /*action.addWorkConsume(contextItemParams(), new HttpCallback<WorkModel>() {
            @Override
            public void onSuccess(WorkModel model) {
                view.showLog("添加工作右侧详情数据：" + model);
                view.initContextItem(model);
            }

            @Override
            public void onFailure(String e) {

            }
        });*/
    }

    private Map<String, Object> contextItemParams() {
        return null;
    }

    private Map<String, Object> classItemParams() {
        return null;
    }
}
