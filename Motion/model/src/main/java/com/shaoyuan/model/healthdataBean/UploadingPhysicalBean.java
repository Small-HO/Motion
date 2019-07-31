package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:11
 * title：上传体质检测报告
 */
public class UploadingPhysicalBean {

    /**
     * method : getabilitylist
     * userid : 16461313546513
     * phytype : 1
     * institutionilist : [{"consttid":"2","valuees":"50"}]
     */

    private String method;
    private String userid;
    private String phytype;
    private List<InstitutionilistBean> institutionilist;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhytype() {
        return phytype;
    }

    public void setPhytype(String phytype) {
        this.phytype = phytype;
    }

    public List<InstitutionilistBean> getInstitutionilist() {
        return institutionilist;
    }

    public void setInstitutionilist(List<InstitutionilistBean> institutionilist) {
        this.institutionilist = institutionilist;
    }

    public static class InstitutionilistBean {
        /**
         * consttid : 2
         * valuees : 50
         */

        private String consttid;
        private String valuees;

        public String getConsttid() {
            return consttid;
        }

        public void setConsttid(String consttid) {
            this.consttid = consttid;
        }

        public String getValuees() {
            return valuees;
        }

        public void setValuees(String valuees) {
            this.valuees = valuees;
        }
    }
}
