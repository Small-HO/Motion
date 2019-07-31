package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 8:43
 * title：删除单条食物信息
 */
public class DeleteOneFoodBean {

    /**
     * repcode : 00
     * repmsg : 删除成功
     * method : userdelfoodinfo
     */

    private String repcode;
    private String repmsg;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
