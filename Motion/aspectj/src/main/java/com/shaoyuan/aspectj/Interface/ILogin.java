package com.shaoyuan.aspectj.Interface;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/3 16:59
 * title：ILogin接口
 */
public interface ILogin {
    /** 登录事件接受 */
    void login(Context context, int actionDefine);
    /** 判断是否登录 */
    boolean isLogin(Context context);
}
