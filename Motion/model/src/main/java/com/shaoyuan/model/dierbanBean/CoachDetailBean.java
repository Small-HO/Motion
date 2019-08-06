package com.shaoyuan.model.dierbanBean;

import java.util.List;

/**
 * Created by gzl on 2019/8/6 10:04
 * title：教练预约详情
 */
public class CoachDetailBean {

    /**
     * areainfo : [{"pic":["http://192.168.1.166:8889/img/15629178743045735-D41D8CD98F00B204E9800998ECF8427E.jpeg"],"areaname":"运动空间","area":"50","capac":"1","equpro":null,"region":"裕华区","lng":114.531099,"lat":38.023281,"machname":"方大健康中心","label":""}]
     * repcode : 00
     * repmsg : 查询成功
     * method : areainfo
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<AreainfoBean> areainfo;

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

    public List<AreainfoBean> getAreainfo() {
        return areainfo;
    }

    public void setAreainfo(List<AreainfoBean> areainfo) {
        this.areainfo = areainfo;
    }

    public static class AreainfoBean {
        /**
         * pic : ["http://192.168.1.166:8889/img/15629178743045735-D41D8CD98F00B204E9800998ECF8427E.jpeg"]
         * areaname : 运动空间
         * area : 50
         * capac : 1
         * equpro : null
         * region : 裕华区
         * lng : 114.531099
         * lat : 38.023281
         * machname : 方大健康中心
         * label :
         */

        private String areaname;
        private String area;
        private String capac;
        private Object equpro;
        private String region;
        private double lng;
        private double lat;
        private String machname;
        private String label;
        private List<String> pic;

        public String getAreaname() {
            return areaname;
        }

        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCapac() {
            return capac;
        }

        public void setCapac(String capac) {
            this.capac = capac;
        }

        public Object getEqupro() {
            return equpro;
        }

        public void setEqupro(Object equpro) {
            this.equpro = equpro;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getMachname() {
            return machname;
        }

        public void setMachname(String machname) {
            this.machname = machname;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public List<String> getPic() {
            return pic;
        }

        public void setPic(List<String> pic) {
            this.pic = pic;
        }
    }
}
