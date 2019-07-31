package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.SecureInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by small-ho on 2019/7/17 16:54
 * title：修改密码核心逻辑
 */
public class SecurePresenter implements SecureInterface.presenter {

    private SecureInterface.view view;
    private AppAction action;

    public SecurePresenter(SecureInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }


    @Override
    public void updatePas() {
        /*action.updatePas(params(), new HttpCallback<BaseModel>() {
            @Override
            public void onSuccess(BaseModel baseModel) {

            }

            @Override
            public void onFailure(String e) {

            }
        });*/
    }

    private Map<String, Object> params() {
        Map<String,Object> params = new HashMap<>();
        params.put("用户id,","");
        params.put("旧密码","");
        params.put("新密码","");
        params.put("再次输入","");
        return params;
    }
}
