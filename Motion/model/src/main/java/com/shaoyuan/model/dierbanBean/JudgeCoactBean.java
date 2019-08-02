package com.shaoyuan.model.dierbanBean;

/**
 * Created by gzl on 2019/8/1 9:20
 * title：判断是不是教练
 */
public class JudgeCoactBean {

    /**
     * method : judgecoach
     * repcode : 00
     * repmsg : 该用户是教练
     * pertype : 0
     */

    private String method;
    private String repcode;
    private String repmsg;
    private String pertype;

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

    public String getPertype() {
        return pertype;
    }

    public void setPertype(String pertype) {
        this.pertype = pertype;
    }

    @Override
    public String toString() {
        return "JudgeCoactBean{" +
                "method='" + method + '\'' +
                ", repcode='" + repcode + '\'' +
                ", repmsg='" + repmsg + '\'' +
                ", pertype='" + pertype + '\'' +
                '}';
    }
}
