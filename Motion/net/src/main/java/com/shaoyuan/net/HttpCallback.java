package com.shaoyuan.net;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.shaoyuan.net.interfaces.ICallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by small-ho on 2019/7/2 10:10
 * title：采用反射获取json所有类型
 */
public abstract class HttpCallback<T> implements ICallback {
    /*@Override
    public void onSuccess(T result) {
    }
*/
    @Override
    public void onSuccess(Object result) {

      /*  Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        T objResult = (T) gson.fromJson(result.toString(),clz);*/
        onSuccesss((T) result);
    }

    @Override
    public void onFailure(String e) {

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

    public abstract void onSuccesss(T result);
}
