package com.shaoyuan.net.interfaces;

/**
 * Created by small-ho on 2019/7/2 10:12
 * title：接口统一回调
 */
public interface ICallback<T> {
    void onSuccess(T result);
    void onFailure(String e);
}
