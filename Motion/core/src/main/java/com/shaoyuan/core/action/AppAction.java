package com.shaoyuan.core.action;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 13:38
 * title：核心层，向下调用Api，向上提供Action，介于api与app之间
 */
public interface AppAction {
//    void login(Map<String,Object> params, HttpCallback<> callback);
    //  发送验证码
    void sendSmsCode(Map<String,Object> params, HttpCallback<SmsCode> callback);

    //  订单列表
    void orderInfo(Map<String,Object> params, HttpCallback<OrderModel> callback);

    //  用户基本信息
    void userInfo(Map<String,Object> params, HttpCallback<UserInfoModel> callback);
    //  保存用户信息
    void userInfoSave(Map<String,Object> params, HttpCallback<BaseModel> callback);
}
