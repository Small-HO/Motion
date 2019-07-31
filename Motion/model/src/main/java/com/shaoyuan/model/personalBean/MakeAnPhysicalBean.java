package com.shaoyuan.model.personalBean;

/**
 * Created by gzl on 2019/7/30 9:58
 * title：预约体检
 */
public class MakeAnPhysicalBean {

    /**
     * method : upexamination
     * repcode : 00
     * repmsg : 预约成功
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
