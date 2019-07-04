package com.shaoyuan.core;

import android.content.Context;

import com.shaoyuan.api.ServiceApi;
import com.shaoyuan.api.ServiceApiImpl;
import com.shaoyuan.core.Interfaces.AppAction;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.net.HttpCallback;
import com.shaoyuan.net.HttpHelper;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 13:45
 * title：核心层实现类
 */
public class AppActionImpl implements AppAction {
    private final static int LOGIN_OS = 1;      //  表示Android
    private final static int PAGE_SIZE = 20;    //  默认每页20条

    private Context context;
    private ServiceApi api;

    public AppActionImpl(Context context){
        this.context = context;
        this.api = new ServiceApiImpl();
    }

    @Override
    public void sendSmsCode(Map<String, Object> params, final HttpCallback<SmsCode> callback) {
        //  参数为空检查
        if (params == null && params.isEmpty()) {
            if (callback != null) {
                callback.onFailure("参数为空");
            }
            return;
        }
        if (params.get("telno") == null && params.get("telno").equals("")) {
            if (callback != null) {
                callback.onFailure("手机号为空");
            }
            return;
        }

        //  手机号校验

        //  网络请求
        HttpHelper.getInstance().post(api.personal("personal"), params, new HttpCallback<SmsCode>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(SmsCode smsCode) {
                callback.onSuccess(smsCode.toString());
            }
        });
    }
}
