package com.shaoyuan.model;

/**
 * Created by small-ho on 2019/7/16 10:57
 * title：数据模型基类
 */
public class BaseModel {
    private String method;
    private String repcode;
    private String repmsg;
    private String models;
    private String alipay;
    private String adwxpay;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRepcode() {
        return repcode;
    }

    public void setRepcode(String repcode) {
        this.repcode = repcode;
    }

    public String getRepmsg() {
        return repmsg;
    }

    public void setRepmsg(String repmsg) {
        this.repmsg = repmsg;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getAdwxpay() {
        return adwxpay;
    }

    public void setAdwxpay(String adwxpay) {
        this.adwxpay = adwxpay;
    }
}
