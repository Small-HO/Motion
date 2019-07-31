package com.shaoyuan.model.personalBean;

/**
 * Created by gzl on 2019/7/29 14:44
 * title：修改个人资料
 */
public class UpdateDataBean {


    /**
     * method : upduserbasicinfo
     * repcode : 00
     * repmsg : 注册成功
     */

    private String method;
    private String repcode;
    private String repmsg;

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
}
