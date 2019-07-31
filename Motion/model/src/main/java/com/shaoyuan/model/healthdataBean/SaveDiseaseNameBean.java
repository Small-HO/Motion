package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:05
 * title：获取疾病名
 */
public class SaveDiseaseNameBean {


    /**
     * diseaselist : [{"disobject":"0","diseasenamelist":[{"diseasename":"糖尿病","diseaseid":"a007"}]},{"disobject":"1","diseasenamelist":[{"diseasename":"低血压","diseaseid":"a057"},{"diseasename":"高血压","diseaseid":"a067"}]}]
     * method : getdiseasenamelist
     */

    private String method;
    private List<DiseaselistBean> diseaselist;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<DiseaselistBean> getDiseaselist() {
        return diseaselist;
    }

    public void setDiseaselist(List<DiseaselistBean> diseaselist) {
        this.diseaselist = diseaselist;
    }

    public static class DiseaselistBean {
        /**
         * disobject : 0
         * diseasenamelist : [{"diseasename":"糖尿病","diseaseid":"a007"}]
         */

        private String disobject;
        private List<DiseasenamelistBean> diseasenamelist;

        public String getDisobject() {
            return disobject;
        }

        public void setDisobject(String disobject) {
            this.disobject = disobject;
        }

        public List<DiseasenamelistBean> getDiseasenamelist() {
            return diseasenamelist;
        }

        public void setDiseasenamelist(List<DiseasenamelistBean> diseasenamelist) {
            this.diseasenamelist = diseasenamelist;
        }

        public static class DiseasenamelistBean {
            /**
             * diseasename : 糖尿病
             * diseaseid : a007
             */

            private String diseasename;
            private String diseaseid;

            public String getDiseasename() {
                return diseasename;
            }

            public void setDiseasename(String diseasename) {
                this.diseasename = diseasename;
            }

            public String getDiseaseid() {
                return diseaseid;
            }

            public void setDiseaseid(String diseaseid) {
                this.diseaseid = diseaseid;
            }
        }
    }
}
