package com.shaoyuan.aspectj.aspect;

import android.content.Context;
import android.util.Log;

import com.shaoyuan.aspectj.Interface.ILogin;
import com.shaoyuan.aspectj.Interface.LoginIntercept;
import com.shaoyuan.aspectj.utils.LoginSDK;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by small-ho on 2019/7/3 17:04
 * title：注解相关的Aspectj的实现类
 */
@Aspect
public class LoginInterceptAspect {
    private static final String Tag = "LoginInterceptAspect";

    /**找到指定注解的切点 */
    @Pointcut("execution(@com.shaoyuan.aspectj.Interface.LoginIntercept * *(..)))")
    public void executeCheckLogin() {}

    /** 切面 */
    @SuppressWarnings("CheckStyle")
    @Around("executeCheckLogin()")
    public void checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        ILogin login = LoginSDK.getInstance().getLogin();

        if (login == null) {
            Log.e(Tag,"LoginSDK没有初始化！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            Log.e(Tag,"LoginIntercept注解只能用于方法上");
        }

        MethodSignature methodSignature  = (MethodSignature) joinPoint.getSignature();
        Log.e("Aspect",String.valueOf(methodSignature.getName()));
        Log.e("Aspect",String.valueOf(methodSignature.getMethod() == null));
        LoginIntercept checkLogin = methodSignature.getMethod().getAnnotation(LoginIntercept.class);

        if (checkLogin == null) {
            return;
        }

        Context param = LoginSDK.getInstance().getContext();
        if (login.isLogin(param)) {
            joinPoint.proceed();
        }else {
            login.login(param,checkLogin.actionDefine());
        }
    }

}
