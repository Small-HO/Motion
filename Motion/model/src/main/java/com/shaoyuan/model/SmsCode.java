package com.shaoyuan.model;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/2 17:19
 * title：
 */
public class SmsCode implements Serializable {
    /**
     * repcode : 00
     * repmsg : 验证码已发送,有效时间两分钟
     * method : getshortmsg
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
