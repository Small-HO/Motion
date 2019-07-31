package com.shaoyuan.model.personalBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 17:34
 * title：首页
 */
public class HomePageBean {
    /**
     * carouselmap : [{"pic1":"http://192.168.1.166:8889/img/banner1.jpg","pic2":"http://192.168.1.166:8889/img/banner2.jpg","pic3":"http://192.168.1.166:8889/img/banner3.jpg"}]
     * repcode : 00
     * repmsg : 获取成功
     * getdata : [{"machid":"15600454431848989","machname":"方大健身健康融合中心","machaddress":"河北省石家庄市裕华区天山大街266号方大科技园6号楼5层","mtime":"周一至周日","detail":"方大健身中心位于方大科技园6号楼5层，环境幽雅舒适.云集业界一流的健身教练.配备高档先进的健身设备..每周多达50节丰富的有养课程.包括时下流行的俞伽.及高温俞伽.活力四射的街舞.肚皮舞.普拉提.有氧搏击操.哑铃等","pic":"http://192.168.1.166:8889/img/1560045443183527470-B4953F2036E9EE9A19D63600CA0BD8D6.jpg","openstatus":"1","popular":"1","pmax":"200","lng":"114.531099","lat":"38.023281"}]
     * method : homeinterface
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<CarouselmapBean> carouselmap;
    private List<GetdataBean> getdata;

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

    public List<CarouselmapBean> getCarouselmap() {
        return carouselmap;
    }

    public void setCarouselmap(List<CarouselmapBean> carouselmap) {
        this.carouselmap = carouselmap;
    }

    public List<GetdataBean> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<GetdataBean> getdata) {
        this.getdata = getdata;
    }

    public static class CarouselmapBean {
        /**
         * pic1 : http://192.168.1.166:8889/img/banner1.jpg
         * pic2 : http://192.168.1.166:8889/img/banner2.jpg
         * pic3 : http://192.168.1.166:8889/img/banner3.jpg
         */

        private String pic1;
        private String pic2;
        private String pic3;

        public String getPic1() {
            return pic1;
        }

        public void setPic1(String pic1) {
            this.pic1 = pic1;
        }

        public String getPic2() {
            return pic2;
        }

        public void setPic2(String pic2) {
            this.pic2 = pic2;
        }

        public String getPic3() {
            return pic3;
        }

        public void setPic3(String pic3) {
            this.pic3 = pic3;
        }
    }

    public static class GetdataBean {
        /**
         * machid : 15600454431848989
         * machname : 方大健身健康融合中心
         * machaddress : 河北省石家庄市裕华区天山大街266号方大科技园6号楼5层
         * mtime : 周一至周日
         * detail : 方大健身中心位于方大科技园6号楼5层，环境幽雅舒适.云集业界一流的健身教练.配备高档先进的健身设备..每周多达50节丰富的有养课程.包括时下流行的俞伽.及高温俞伽.活力四射的街舞.肚皮舞.普拉提.有氧搏击操.哑铃等
         * pic : http://192.168.1.166:8889/img/1560045443183527470-B4953F2036E9EE9A19D63600CA0BD8D6.jpg
         * openstatus : 1
         * popular : 1
         * pmax : 200
         * lng : 114.531099
         * lat : 38.023281
         */

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

        public String getMachaddress() {
            return machaddress;
        }

        public void setMachaddress(String machaddress) {
            this.machaddress = machaddress;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getOpenstatus() {
            return openstatus;
        }

        public void setOpenstatus(String openstatus) {
            this.openstatus = openstatus;
        }

        public String getPopular() {
            return popular;
        }

        public void setPopular(String popular) {
            this.popular = popular;
        }

        public String getPmax() {
            return pmax;
        }

        public void setPmax(String pmax) {
            this.pmax = pmax;
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
    }
}
