package com.shaoyuan.model.personalBean;

/**
 * Created by gzl on 2019/7/29 14:58
 * title：修改密码
 */
public class UpPasswordBean {

    /**
     * method : changepwd
     * repcode : 00
     * repmsg : 修改成功
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
