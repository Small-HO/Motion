package com.shaoyuan.model.personalBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/29 14:55
 * title：常见问题
 */
public class FAQBean {

    /**
     * method : commonqselist
     * repcode : 00
     * repmsg : 获取成功
     * monqselist : [{"comname":"问题","spoexpain":"解释"}]
     */

    private String method;
    private String repcode;
    private String repmsg;
    private List<MonqselistBean> monqselist;

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

    public List<MonqselistBean> getMonqselist() {
        return monqselist;
    }

    public void setMonqselist(List<MonqselistBean> monqselist) {
        this.monqselist = monqselist;
    }

    public static class MonqselistBean {
        /**
         * comname : 问题
         * spoexpain : 解释
         */

        private String comname;
        private String spoexpain;

        public String getComname() {
            return comname;
        }

        public void setComname(String comname) {
            this.comname = comname;
        }

        public String getSpoexpain() {
            return spoexpain;
        }

        public void setSpoexpain(String spoexpain) {
            this.spoexpain = spoexpain;
        }
    }
}
