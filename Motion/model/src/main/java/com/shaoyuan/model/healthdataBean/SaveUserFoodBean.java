package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 8:51
 * title：保存用户食物摄入信息
 */
public class SaveUserFoodBean {


    /**
     * repcode : 00
     * repmsg : 添加成功
     * method : saveuserintake
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
