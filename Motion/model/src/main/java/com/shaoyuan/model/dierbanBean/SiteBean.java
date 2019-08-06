package com.shaoyuan.model.dierbanBean;

import java.util.List;

/**
 * Created by gzl on 2019/8/1 13:28
 * title：
 */
public class SiteBean {

    /**
     * method : venuelist
     * repcode : 00
     * repmsg : 查询成功
     * data : [{"machid":"1364659861361","machname":"方大健康中心","area":"裕华区","pic":"http://192.168.1.166/img/safdasfasff.jpeg","lng":"40.1656","lat":"126.23556","price":"9.9"},"....."]
     */

    private String method;
    private String repcode;
    private String repmsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * machid : 1364659861361
         * machname : 方大健康中心
         * area : 裕华区
         * pic : http://192.168.1.166/img/safdasfasff.jpeg
         * lng : 40.1656
         * lat : 126.23556
         * price : 9.9
         */

        private String machid;
        private String machname;
        private String area;
        private String pic;
        private String lng;
        private String lat;
        private String price;
        private String areaid;

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }

        public String getMachid() {
            return machid;
        }

        public void setMachid(String machid) {
            this.machid = machid;
        }

        public String getMachname() {
            return machname;
        }

        public void setMachname(String machname) {
            this.machname = machname;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
