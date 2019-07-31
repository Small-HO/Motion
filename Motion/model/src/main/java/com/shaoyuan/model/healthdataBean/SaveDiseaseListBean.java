package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 16:58
 * title：获取人群/疾病列表
 */
public class SaveDiseaseListBean {
        private String repcode;
        private String repmsg;
        private List<Diseaselist> diseaselist;
        private List<Crowdlist> crowdlist;
        private String method;
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

        public void setDiseaselist(List<Diseaselist> diseaselist) {
            this.diseaselist = diseaselist;
        }
        public List<Diseaselist> getDiseaselist() {
            return diseaselist;
        }

        public void setCrowdlist(List<Crowdlist> crowdlist) {
            this.crowdlist = crowdlist;
        }
        public List<Crowdlist> getCrowdlist() {
            return crowdlist;
        }

        public void setMethod(String method) {
            this.method = method;
        }
        public String getMethod() {
            return method;
        }

    public static class Diseaselist {

        private String diseasename;
        private String diseaseid;
        public void setDiseasename(String diseasename) {
            this.diseasename = diseasename;
        }
        public String getDiseasename() {
            return diseasename;
        }

        public void setDiseaseid(String diseaseid) {
            this.diseaseid = diseaseid;
        }
        public String getDiseaseid() {
            return diseaseid;
        }

    }

    public static class Crowdlist {

        private String labelname;
        private String labelid;
        public void setLabelname(String labelname) {
            this.labelname = labelname;
        }
        public String getLabelname() {
            return labelname;
        }

        public void setLabelid(String labelid) {
            this.labelid = labelid;
        }
        public String getLabelid() {
            return labelid;
        }

    }
}
