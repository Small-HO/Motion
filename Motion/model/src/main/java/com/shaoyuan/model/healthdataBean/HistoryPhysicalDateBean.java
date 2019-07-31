package com.shaoyuan.model.healthdataBean;

import java.util.Date;
import java.util.List;

/**
 * Created by gzl on 2019/7/30 15:33
 * title：获取历史体质/体能/病历日期
 */
public class HistoryPhysicalDateBean {
    private List<Historyolist> historyolist;
    private String repcode;
    private String repmsg;
    private String method;
    public void setHistoryolist(List<Historyolist> historyolist) {
        this.historyolist = historyolist;
    }
    public List<Historyolist> getHistoryolist() {
        return historyolist;
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

    public static class Historyolist {

        private Date retime;
        public void setRetime(Date retime) {
            this.retime = retime;
        }
        public Date getRetime() {
            return retime;
        }

    }
}
