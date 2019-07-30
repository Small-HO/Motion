package com.shaoyuan.model.personalBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/29 15:04
 * title：体检详情
 */
public class PhysicalDetailsBean {

    /**
     * repcode : 00
     * repmsg : 获取成功
     * mechaddress : 河北省石家庄市长安区广安大街时代方舟C座 四、五层
     * setmealname : 初入职场套餐二
     * setmealprice : 0.01
     * exhpic : http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA281.png
     * setmealprices : 245
     * lng : 114.608288
     * lat : 38.01946
     * disease : [{"disname":"肿瘤筛查","dispic":"http://192.168.1.166:8889/img/physical/肿瘤筛查.png"},{"disname":"甲状腺疾病","dispic":"http://192.168.1.166:8889/img/physical/甲状腺疾病.png"},{"disname":"前列腺检查","dispic":"http://192.168.1.166:8889/img/physical/前列腺检查.png"},{"disname":"颈椎疾病","dispic":"http://192.168.1.166:8889/img/physical/颈椎疾病.png"}]
     * mechid : 15563317545982135
     * mechname : 长城体检中心
     * minationlist : [{"detectionname":"内科","inspectcontent":"心脏的位置、大小、外形及搏动规律等基本状态。；呼吸运动及肺呼吸音检查。；腹部各脏器大小、形态、质地、压痛感检查。；双下肢水肿检查和神经系统检查。","inspectgoal":"对许多疾病，如气管炎、支气管炎、肺炎、胸膜炎、心律失常、心包炎、心肺功能不全、心力衰竭、肝脾肿大、贫血、黄疸、胃肠道疾病、脑血管疾病等有初步筛查和诊断作用。"},{"detectionname":"肝功八项","inspectcontent":"谷丙转氨酶、谷草转氨酶、γ-谷氨酰基转移酶、总蛋白、白蛋白、总胆红素、直接胆红素、间接胆红素。","inspectgoal":"是检测肝脏功能和病毒感染的损伤程度的重要指标，进一步了解肝硬化和蛋白质含量及水平变化情况等。"},{"detectionname":"全外显子组序列基因","inspectcontent":"","inspectgoal":""},{"detectionname":"钛夹","inspectcontent":"","inspectgoal":""},{"detectionname":"胸片（微机保存）","inspectcontent":"双肺、胸椎、肋骨、心脏等","inspectgoal":"气管炎、肺炎、肺癌、肺结核、胸部骨质情况、心脏疾病等诊断，并留存图像档案纵向对比"}]
     * total : 5
     * method : getexamination
     */

    private String repcode;
    private String repmsg;
    private String mechaddress;
    private String setmealname;
    private String setmealprice;
    private String exhpic;
    private String setmealprices;
    private String lng;
    private String lat;
    private String mechid;
    private String mechname;
    private int total;
    private String method;
    private List<DiseaseBean> disease;
    private List<MinationlistBean> minationlist;

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

    public String getMechaddress() {
        return mechaddress;
    }

    public void setMechaddress(String mechaddress) {
        this.mechaddress = mechaddress;
    }

    public String getSetmealname() {
        return setmealname;
    }

    public void setSetmealname(String setmealname) {
        this.setmealname = setmealname;
    }

    public String getSetmealprice() {
        return setmealprice;
    }

    public void setSetmealprice(String setmealprice) {
        this.setmealprice = setmealprice;
    }

    public String getExhpic() {
        return exhpic;
    }

    public void setExhpic(String exhpic) {
        this.exhpic = exhpic;
    }

    public String getSetmealprices() {
        return setmealprices;
    }

    public void setSetmealprices(String setmealprices) {
        this.setmealprices = setmealprices;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getMechid() {
        return mechid;
    }

    public void setMechid(String mechid) {
        this.mechid = mechid;
    }

    public String getMechname() {
        return mechname;
    }

    public void setMechname(String mechname) {
        this.mechname = mechname;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<DiseaseBean> getDisease() {
        return disease;
    }

    public void setDisease(List<DiseaseBean> disease) {
        this.disease = disease;
    }

    public List<MinationlistBean> getMinationlist() {
        return minationlist;
    }

    public void setMinationlist(List<MinationlistBean> minationlist) {
        this.minationlist = minationlist;
    }

    public static class DiseaseBean {
        /**
         * disname : 肿瘤筛查
         * dispic : http://192.168.1.166:8889/img/physical/肿瘤筛查.png
         */

        private String disname;
        private String dispic;

        public String getDisname() {
            return disname;
        }

        public void setDisname(String disname) {
            this.disname = disname;
        }

        public String getDispic() {
            return dispic;
        }

        public void setDispic(String dispic) {
            this.dispic = dispic;
        }
    }

    public static class MinationlistBean {
        /**
         * detectionname : 内科
         * inspectcontent : 心脏的位置、大小、外形及搏动规律等基本状态。；呼吸运动及肺呼吸音检查。；腹部各脏器大小、形态、质地、压痛感检查。；双下肢水肿检查和神经系统检查。
         * inspectgoal : 对许多疾病，如气管炎、支气管炎、肺炎、胸膜炎、心律失常、心包炎、心肺功能不全、心力衰竭、肝脾肿大、贫血、黄疸、胃肠道疾病、脑血管疾病等有初步筛查和诊断作用。
         */

        private String detectionname;
        private String inspectcontent;
        private String inspectgoal;

        public String getDetectionname() {
            return detectionname;
        }

        public void setDetectionname(String detectionname) {
            this.detectionname = detectionname;
        }

        public String getInspectcontent() {
            return inspectcontent;
        }

        public void setInspectcontent(String inspectcontent) {
            this.inspectcontent = inspectcontent;
        }

        public String getInspectgoal() {
            return inspectgoal;
        }

        public void setInspectgoal(String inspectgoal) {
            this.inspectgoal = inspectgoal;
        }
    }
}
