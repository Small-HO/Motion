package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 17:15
 * title：运动中心
 */
public class SportsCenterBean {
    private String repcode;
    private String repmsg;
    private List<Getdata> getdata;
    private String huiyuan;
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

    public void setGetdata(List<Getdata> getdata) {
        this.getdata = getdata;
    }
    public List<Getdata> getGetdata() {
        return getdata;
    }

    public void setHuiyuan(String huiyuan) {
        this.huiyuan = huiyuan;
    }
    public String getHuiyuan() {
        return huiyuan;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }

    public static class Getdata {

        private String machid;
        private String machname;
        private String machaddress;
        private String mtime;
        private String detail;
        private String pic;
        private String openstatus;
        private String popular;
        private String pmax;
        private String lng;
        private String lat;
        public void setMachid(String machid) {
            this.machid = machid;
        }
        public String getMachid() {
            return machid;
        }

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

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }
        public String getMtime() {
            return mtime;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
        public String getDetail() {
            return detail;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
        public String getPic() {
            return pic;
        }

        public void setOpenstatus(String openstatus) {
            this.openstatus = openstatus;
        }
        public String getOpenstatus() {
            return openstatus;
        }

        public void setPopular(String popular) {
            this.popular = popular;
        }
        public String getPopular() {
            return popular;
        }

        public void setPmax(String pmax) {
            this.pmax = pmax;
        }
        public String getPmax() {
            return pmax;
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

    }

}
