package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.ScreenInreface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.personalBean.PhysicalListBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
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
        action.physicalList(params(), new HttpCallback<PhysicalListBean>() {
            @Override
            public void onSuccesss(PhysicalListBean result) {
                view.showLog("健康体检列表数据：" + result);
                view.initScreenDatas(result);
            }

            @Override
            public void onFailures(String erro) {

            }
        });
    }

    private Map<String, Object> params() {
        Map<String,Object> params = new HashMap<>();
        params.put("method","getphysicallist");
        params.put("beginline","1");
        params.put("count","20");
        params.put("sex","");
        params.put("crowd","");
        params.put("disease","");
        return params;
    }
}
