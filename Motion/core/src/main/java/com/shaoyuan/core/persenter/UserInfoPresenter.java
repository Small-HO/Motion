package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.UserInfoInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.net.HttpCallback;

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
        action.userInfo(view.params(), new HttpCallback<UserInfoModel>() {
            @Override
            public void onSuccess(UserInfoModel model) {
                view.showLog("用户详情：" + model);
                view.initUserDatas(model);
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }

}
