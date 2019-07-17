package com.shaoyuan.core.actionImpl;

import android.content.Context;

import com.shaoyuan.api.ServiceApi;
import com.shaoyuan.api.ServiceApiImpl;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataInfo.OrderInfo;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.net.HttpCallback;
import com.shaoyuan.net.HttpHelper;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void orderInfo(Map<String, Object> params, HttpCallback<OrderModel> callback) {
        //  模拟数据
        OrderModel model = new OrderModel();
        List<OrderInfo> list = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setTemstype("场地");
        info.setSetmealprice("0.01");
        info.setPaystate(false);
        info.setCreattime("2019-07-15 09:13:57");
        info.setMechname("团操室");
        list.add(info);
        model.setOrderInfos(list);

        callback.onSuccess(model);
    }

    @Override
    public void userInfo(Map<String, Object> params, HttpCallback<UserInfoModel> callback) {
        //  模拟数据
        UserInfoModel model = new UserInfoModel();
        model.setNickname("小油瓶");
        model.setSex("女");
        model.setBirthdate("2019");
        model.setHeight("1.8");
        model.setWeight("145");

        callback.onSuccess(model);
    }

    @Override
    public void userInfoSave(Map<String, Object> params, HttpCallback<BaseModel> callback) {
        //  模拟数据
        BaseModel model = new BaseModel();

        callback.onSuccess(model);
    }
}
