package com.shaoyuan.model.personalBean;

/**
 * Created by gzl on 2019/7/29 14:53
 * title：意见反馈
 */
public class FeedbackBean {

    /**
     * method : feedback
     * repcode : 00
     * repmsg : 反馈成功
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
