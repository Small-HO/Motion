package com.shaoyuan.net.interfaces;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 10:14
 * title：代理接口
 */
public interface IHttpProcessor {
    void post(String url, Map<String,Object> params,ICallback callback);
    void get(String url,Map<String,Object> params,ICallback callback);
}
