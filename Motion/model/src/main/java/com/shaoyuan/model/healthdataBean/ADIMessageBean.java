package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:49
 * title：摄入量信息展示
 */
public class ADIMessageBean {


    /**
     * repcode : 00
     * repmsg : 获取成功
     * getdata : [{"daytime":"2019-07-29","info":1000},{"daytime":"2019-04-18","info":1250},{"daytime":"2019-04-15","info":1600},{"daytime":"2019-03-15","info":800},{"daytime":"2018-04-15","info":500}]
     * method : showpowercon
     */

    private String repcode;
    private String repmsg;
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
         * daytime : 2019-07-29
         * info : 1000
         */

        private String daytime;
        private int info;

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public int getInfo() {
            return info;
        }

        public void setInfo(int info) {
            this.info = info;
        }
    }
}
