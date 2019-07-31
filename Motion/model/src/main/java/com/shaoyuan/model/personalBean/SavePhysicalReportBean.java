package com.shaoyuan.model.personalBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 10:00
 * title：获取体检报告
 */
public class SavePhysicalReportBean {

    /**
     * method : getphysical
     * repcode : 00
     * repmsg : 获取体检结果报告成功
     * overview : 阿斯顿福建噢安抚
     * appttime : 2019-07-29
     * cycles : 180
     * physicallist : [{"diseasename":"高血压","doctoradvice":"医生建议","attentions":"注意事项"}]
     */

    private String method;
    private String repcode;
    private String repmsg;
    private String overview;
    private String appttime;
    private String cycles;
    private List<PhysicallistBean> physicallist;

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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getAppttime() {
        return appttime;
    }

    public void setAppttime(String appttime) {
        this.appttime = appttime;
    }

    public String getCycles() {
        return cycles;
    }

    public void setCycles(String cycles) {
        this.cycles = cycles;
    }

    public List<PhysicallistBean> getPhysicallist() {
        return physicallist;
    }

    public void setPhysicallist(List<PhysicallistBean> physicallist) {
        this.physicallist = physicallist;
    }

    public static class PhysicallistBean {
        /**
         * diseasename : 高血压
         * doctoradvice : 医生建议
         * attentions : 注意事项
         */

        private String diseasename;
        private String doctoradvice;
        private String attentions;

        public String getDiseasename() {
            return diseasename;
        }

        public void setDiseasename(String diseasename) {
            this.diseasename = diseasename;
        }

        public String getDoctoradvice() {
            return doctoradvice;
        }

        public void setDoctoradvice(String doctoradvice) {
            this.doctoradvice = doctoradvice;
        }

        public String getAttentions() {
            return attentions;
        }

        public void setAttentions(String attentions) {
            this.attentions = attentions;
        }
    }
}
