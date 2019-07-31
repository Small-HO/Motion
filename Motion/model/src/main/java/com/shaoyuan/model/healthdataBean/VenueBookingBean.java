package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 17:24
 * title：场地预约
 */
public class VenueBookingBean {

    private String method;
    private String repcode;
    private String repmsg;
    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }

    public void setRepcode(String repcode) {
        this.repcode = repcode;
    }
    public String getRepcode() {
        return repcode;
    }

    public void setRepmsg(String repmsg) {
        this.repmsg = repmsg;
    }
    public String getRepmsg() {
        return repmsg;
    }

}
