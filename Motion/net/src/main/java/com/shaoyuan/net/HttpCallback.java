package com.shaoyuan.net;

import com.shaoyuan.net.interfaces.ICallback;

/**
 * Created by small-ho on 2019/7/2 10:10
 * title：采用反射获取json所有类型
 */
public abstract class HttpCallback<T> implements ICallback {

    @Override
    public void onSuccess(Object result) {
        onSuccesss((T) result);
    }

    @Override
    public void onFailure(String result) {
        onFailures(result);
    }

    public abstract void onSuccesss(T result);

    public abstract void onFailures(String erro);
}
