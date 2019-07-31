package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 9:53
 * title：预约体能/体质检测
 */
public class MakePhysicalBean {

    /**
     * method : getfitnesss
     * repcode : 00
     * repmsg : 预约已提交
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
