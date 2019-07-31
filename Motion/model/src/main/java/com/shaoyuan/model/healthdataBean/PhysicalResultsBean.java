package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:08
 * title：获取体质检测结果
 */
public class PhysicalResultsBean {

    /**
     * repcode : 01
     * repmsg : 没有结果
     * institutionilist : [{"standardname":"体重","valuees":"0","states":"0"},{"standardname":"脂肪","valuees":"0","states":"0"},{"standardname":"体脂率","valuees":"0","states":"0"},{"standardname":"蛋白质","valuees":"0","states":"0"},{"standardname":"水分率","valuees":"0","states":"0"},{"standardname":"肌肉量","valuees":"0","states":"0"},{"standardname":"骨量","valuees":"0","states":"0"},{"standardname":"内脏脂肪","valuees":"0","states":"0"},{"standardname":"BMR","valuees":"0","states":"0"},{"standardname":"BMI","valuees":"0","states":"0"}]
     * method : getinstitutionilist
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<InstitutionilistBean> institutionilist;

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

    public List<InstitutionilistBean> getInstitutionilist() {
        return institutionilist;
    }

    public void setInstitutionilist(List<InstitutionilistBean> institutionilist) {
        this.institutionilist = institutionilist;
    }

    public static class InstitutionilistBean {
        /**
         * standardname : 体重
         * valuees : 0
         * states : 0
         */

        private String standardname;
        private String valuees;
        private String states;

        public String getStandardname() {
            return standardname;
        }

        public void setStandardname(String standardname) {
            this.standardname = standardname;
        }

        public String getValuees() {
            return valuees;
        }

        public void setValuees(String valuees) {
            this.valuees = valuees;
        }

        public String getStates() {
            return states;
        }

        public void setStates(String states) {
            this.states = states;
        }
    }
}
