package com.shaoyuan.api;

/**
 * Created by small-ho on 2019/7/2 13:47
 * title：
 */
public class ServiceApiImpl implements ServiceApi {

    private final static String HttpUrl = "http://192.168.1.166:8889/";

    @Override
    public String personal(String model) {
        return HttpUrl + model;
    }
}
