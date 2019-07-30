package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:02
 * title：获取当天总摄入健康数据报告
 */
public class SaveSumIntakeBean {


    /**
     * countrew : 20.14
     * getdata : [{"tmtype":"早餐","foodh":"0","foodq":"0"},{"tmtype":"午餐","foodh":20.14,"foodq":41},{"tmtype":"晚餐","foodh":"0","foodq":"0"},{"tmtype":"加餐","foodh":"0","foodq":"0"}]
     * repcode : 00
     * repmsg : 获取成功
     * method : getdatareportintaketoday
     */

    private double countrew;
    private String repcode;
    private String repmsg;
    private String method;
    private List<GetdataBean> getdata;

    public double getCountrew() {
        return countrew;
    }

    public void setCountrew(double countrew) {
        this.countrew = countrew;
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
         * tmtype : 早餐
         * foodh : 0
         * foodq : 0
         */

        private String tmtype;
        private String foodh;
        private String foodq;

        public String getTmtype() {
            return tmtype;
        }

        public void setTmtype(String tmtype) {
            this.tmtype = tmtype;
        }

        public String getFoodh() {
            return foodh;
        }

        public void setFoodh(String foodh) {
            this.foodh = foodh;
        }

        public String getFoodq() {
            return foodq;
        }

        public void setFoodq(String foodq) {
            this.foodq = foodq;
        }
    }
}
