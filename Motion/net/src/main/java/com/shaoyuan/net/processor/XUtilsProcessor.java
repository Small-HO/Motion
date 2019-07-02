package com.shaoyuan.net.processor;

import android.app.Application;

import com.shaoyuan.net.interfaces.ICallback;
import com.shaoyuan.net.interfaces.IHttpProcessor;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 11:23
 * title：XUtils网络框架
 */
public class XUtilsProcessor implements IHttpProcessor {

    private static final String Tag = "XUtilsProcessor";
    public XUtilsProcessor(Application app) {x.Ext.init(app);}

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
