package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:54
 * title：获取当天消耗健康数据报告
 */
public class ConsumeHealthyDataBean {


    /**
     * repcode : 00
     * repmsg : 获取成功
     * countres : 1000
     * getdata : [{"contype":"工作","conmany":"0","contime":"0"},{"contype":"睡眠","conmany":"0","contime":"0"},{"contype":"休闲","conmany":"0","contime":"0"},{"contype":"运动","conmany":1000,"contime":4}]
     * weight : 56
     * method : getdatareportcontoday
     */

    private String repcode;
    private String repmsg;
    private int countres;
    private String weight;
    private String method;
    private List<GetdataBean> getdata;

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

    public int getCountres() {
        return countres;
    }

    public void setCountres(int countres) {
        this.countres = countres;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<GetdataBean> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<GetdataBean> getdata) {
        this.getdata = getdata;
    }

    public static class GetdataBean {
        /**
         * contype : 工作
         * conmany : 0
         * contime : 0
         */

        private String contype;
        private String conmany;
        private String contime;

        public String getContype() {
            return contype;
        }

        public void setContype(String contype) {
            this.contype = contype;
        }

        public String getConmany() {
            return conmany;
        }

        public void setConmany(String conmany) {
            this.conmany = conmany;
        }

        public String getContime() {
            return contime;
        }

        public void setContime(String contime) {
            this.contime = contime;
        }
    }
}
