package com.shaoyuan.core.action;

import com.shaoyuan.model.SmsCode;
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
}
