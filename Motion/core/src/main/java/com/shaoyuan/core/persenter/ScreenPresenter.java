package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.ScreenInreface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.ScreenModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/29 10:03
 * title：健康体检列表核心逻辑
 */
public class ScreenPresenter implements ScreenInreface.presenter {
    private ScreenInreface.view view;
    private AppAction action;

    public ScreenPresenter(ScreenInreface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initScreenDatas() {
       /* action.sceenList(params(), new HttpCallback<ScreenModel>() {
            @Override
            public void onSuccess(ScreenModel screenModel) {
                view.showLog("健康体检列表数据：" + screenModel);
                view.initScreenDatas(screenModel);
            }

            @Override
            public void onFailure(String e) {

            }
        });*/
    }

    private Map<String, Object> params() {
        return null;
    }
}
