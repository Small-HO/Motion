package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 17:21
 * title：器材预约
 */
public class EquipmentBookingBean {

    private String recordid;
    private String repcode;
    private String repmsg;
    private String method;
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }
    public String getRecordid() {
        return recordid;
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

    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }
}
