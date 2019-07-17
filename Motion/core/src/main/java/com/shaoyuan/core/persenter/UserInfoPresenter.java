package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.UserInfoInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by small-ho on 2019/7/16 16:08
 * title：用户详情核心类
 */
public class UserInfoPresenter implements UserInfoInterface.presenter {
    private UserInfoInterface.view view;
    private AppAction action;

    public UserInfoPresenter(UserInfoInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initUserDatas() {
        action.userInfo(userParams(), new HttpCallback<UserInfoModel>() {
            @Override
            public void onSuccess(UserInfoModel model) {
                view.showLog("用户详情：" + model);
                view.initUserDatas(model);      //  显示用户详情数据
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }

    @Override
    public void saveUserDatas() {
        action.userInfoSave(userSaveParams(), new HttpCallback<BaseModel>() {
            @Override
            public void onSuccess(BaseModel baseModel) {

            }

            @Override
            public void onFailure(String e) {

            }
        });
    }

    private Map<String, Object> userSaveParams() {
        Map<String,Object> params = new HashMap<>();
        params.put("name",view.getName());
        params.put("sex",view.getSex());
        params.put("birthday",view.getBirthday());
        params.put("stature",view.getStature());
        params.put("weight",view.getWeight());
        view.showLog("获取测试值：" + params.toString());
        return params;
    }

    private Map<String, Object> userParams() {
        Map<String,Object> params = new HashMap<>();
        params.put("测试 ","");
        params.put("测试","");
        return params;
    }
}
