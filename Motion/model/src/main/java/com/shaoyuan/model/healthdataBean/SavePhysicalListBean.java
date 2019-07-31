package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 16:53
 * title：获取体能/体质机构测试列表
 */
public class SavePhysicalListBean {

    private String repcode;
    private String repmsg;
    private List<Abilitylist> abilitylist;
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

    public void setAbilitylist(List<Abilitylist> abilitylist) {
        this.abilitylist = abilitylist;
    }
    public List<Abilitylist> getAbilitylist() {
        return abilitylist;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }

    public static class Abilitylist {

        private String machname;
        private String machaddress;
        private String machid;
        private String lng;
        private String lat;
        private String pic;
        public void setMachname(String machname) {
            this.machname = machname;
        }
        public String getMachname() {
            return machname;
        }

        public void setMachaddress(String machaddress) {
            this.machaddress = machaddress;
        }
        public String getMachaddress() {
            return machaddress;
        }

        public void setMachid(String machid) {
            this.machid = machid;
        }
        public String getMachid() {
            return machid;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
        public String getLng() {
            return lng;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLat() {
            return lat;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
        public String getPic() {
            return pic;
        }

    }
}
