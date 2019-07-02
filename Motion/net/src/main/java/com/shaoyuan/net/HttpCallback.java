package com.shaoyuan.net;

import com.google.gson.Gson;
import com.shaoyuan.net.interfaces.ICallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by small-ho on 2019/7/2 10:10
 * title：采用反射获取json所有类型
 */
public abstract class HttpCallback<Result> implements ICallback {
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result,clz);
        onSuccess(objResult);
    }

    private Class<?> analysisClassInfo(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] params = parameterizedType.getActualTypeArguments();
            return (Class<?>) params[0];
        }else {
            return (Class<?>) type;
        }
    }
    abstract void onSuccess(Result result);
}
