package com.shaoyuan.net;

import android.net.Uri;

import com.shaoyuan.net.interfaces.ICallback;
import com.shaoyuan.net.interfaces.IHttpProcessor;

import java.util.Map;
import java.util.Set;

/**
 * Created by small-ho on 2019/7/2 10:10
 * title：代理对象
 */
public class HttpHelper implements IHttpProcessor {

    private static IHttpProcessor mIHttpProcessor = null;
    private static HttpHelper instance;
    private HttpHelper(){}

    public static HttpHelper getInstance() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    public static void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        String finalUrl = appendParams(url,params);
        mIHttpProcessor.post(finalUrl,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        String finalUrl = appendParams(url,params);
        mIHttpProcessor.get(finalUrl,params,callback);
    }

    /** 拼接字符串 */
    private String appendParams(String url, Map<String, Object> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            builder.appendQueryParameter(key, String.valueOf(params.get(key)));
        }
        return builder.build().toString();
    }
}
