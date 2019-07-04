package com.shaoyuan.core;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.shaoyuan.aspectj.Interface.ILogin;
import com.shaoyuan.aspectj.utils.LoginSDK;
import com.shaoyuan.net.HttpHelper;
import com.shaoyuan.net.processor.OkHttpProcessor;

/**
 * Created by small-ho on 2019/7/2 11:27
 * title：全局初始化
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new OkHttpProcessor());             //  网络框架切换初始化
        LoginSDK.getInstance().init(this,login);    //  用户登录状态初始化
    }

    private ILogin login = new ILogin() {
        @Override
        public void login(Context context, int actionDefine) {
            switch (actionDefine)
            {
                case 0:
//                    startActivity(new Intent(context,LoginActivity.class));
                    break;
                default:
            }
        }

        /** 此处检测用户登录状态 */
        @Override
        public boolean isLogin(Context context) {
            return false;
        }
    };
}
