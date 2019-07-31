package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 8:57
 * title：获取用户当天的总消耗和总摄入
 */
public class UserConsumeIntakeBean {

    /**
     * repcode : 00
     * repmsg : 获取成功
     * congetdata : 0
     * intakegetdata : 0
     * method : getcountcontoday
     */

    private String repcode;
    private String repmsg;
    private String congetdata;
    private String intakegetdata;
    private String method;

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

    public String getCongetdata() {
        return congetdata;
    }

    public void setCongetdata(String congetdata) {
        this.congetdata = congetdata;
    }

    public String getIntakegetdata() {
        return intakegetdata;
    }

    public void setIntakegetdata(String intakegetdata) {
        this.intakegetdata = intakegetdata;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
