package com.shaoyuan.model.healthdataBean;

/**
 * Created by gzl on 2019/7/30 9:50
 * title：获取体能检测结果
 */
public class SaveStaminaResultBean {

    /**
     * core : 60
     * thelegs : 80
     * upperlimb : 80
     * pliable : 80
     * pulmonary : 0
     * score : 0
     * repcode : 01
     * repmsg : 数据不全，无法评估
     * method : getfitness
     */

    private int core;
    private int thelegs;
    private int upperlimb;
    private int pliable;
    private int pulmonary;
    private int score;
    private String repcode;
    private String repmsg;
    private String method;

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getThelegs() {
        return thelegs;
    }

    public void setThelegs(int thelegs) {
        this.thelegs = thelegs;
    }

    public int getUpperlimb() {
        return upperlimb;
    }

    public void setUpperlimb(int upperlimb) {
        this.upperlimb = upperlimb;
    }

    public int getPliable() {
        return pliable;
    }

    public void setPliable(int pliable) {
        this.pliable = pliable;
    }

    public int getPulmonary() {
        return pulmonary;
    }

    public void setPulmonary(int pulmonary) {
        this.pulmonary = pulmonary;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
}
