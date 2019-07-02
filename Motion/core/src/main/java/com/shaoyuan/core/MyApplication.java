package com.shaoyuan.core;

import android.app.Application;

import com.shaoyuan.net.HttpHelper;
import com.shaoyuan.net.processor.OkHttpProcessor;

/**
 * Created by small-ho on 2019/7/2 11:27
 * title：全局初始化
 */
public class MyApplication extends Application {
    private AppAction appAction;
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new OkHttpProcessor()); //  网络框架切换初始化
        appAction = new AppActionImpl(this);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
