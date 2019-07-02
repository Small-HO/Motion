package com.shaoyuan.core;

import android.app.Application;

import com.shaoyuan.net.HttpHelper;
import com.shaoyuan.net.processor.XUtilsProcessor;

/**
 * Created by small-ho on 2019/7/2 11:27
 * title：全局初始化
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new XUtilsProcessor(this)); //  网络框架切换初始化
    }
}
