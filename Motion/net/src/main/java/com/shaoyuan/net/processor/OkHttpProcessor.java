package com.shaoyuan.net.processor;

import android.os.Handler;

import com.shaoyuan.net.interfaces.ICallback;
import com.shaoyuan.net.interfaces.IHttpProcessor;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by small-ho on 2019/7/2 11:08
 * title：OkHttp网络框架
 */
public class OkHttpProcessor implements IHttpProcessor {
    private static final String Tag = "OkHttpProcessor";
    private OkHttpClient mOkHttpClient = null;
    private Handler mHandler;

    public OkHttpProcessor(){mOkHttpClient = new OkHttpClient();mHandler = new Handler();}

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestBody requestBody = appendBody(params);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                }else {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(result);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                callback.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });

                }else {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(result);
                        }
                    });
                }
            }
        });
    }

    /** 拼接网络访问请求地址 */
    private RequestBody appendBody(Map<String, Object> params) {

        FormBody.Builder body = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return body.build();
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            body.add(entry.getKey(),entry.getValue().toString());
        }

        return body.build();
    }
}
