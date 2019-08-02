package com.shaoyuan.model.personalBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/29 15:04
 * title：体检列表
 */
public class PhysicalListBean {

    /**
     * repcode : 00
     * repmsg : 获取成功
     * physicallist : [{"setmealname":"初入职场套餐二","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA291.png","crowd":"5","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"245","lng":"114.608288","lat":"38.01946","setmealid":"15637006780341589"},{"setmealname":"初入职场套餐一","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA292.png","crowd":"5","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"145","lng":"114.608288","lat":"38.01946","setmealid":"15637006851522117"},{"setmealname":"都市白领C1套餐（男）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA293.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1076","lng":"114.608288","lat":"38.01946","setmealid":"15637007356397562"},{"setmealname":"都市白领C1套餐（女）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA294.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1320","lng":"114.608288","lat":"38.01946","setmealid":"15637007441522458"},{"setmealname":"都市白领C2套餐（男）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA293.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1451","lng":"114.608288","lat":"38.01946","setmealid":"15637007502958727"},{"setmealname":"都市白领C2套餐（女）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA294.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1721","lng":"114.608288","lat":"38.01946","setmealid":"15637007561360557"},{"setmealname":"都市白领D套餐（男）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA293.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1801","lng":"114.608288","lat":"38.01946","setmealid":"15637007625875726"},{"setmealname":"都市白领D套餐（女）","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA294.png","crowd":"1","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"2071","lng":"114.608288","lat":"38.01946","setmealid":"15637007688082914"},{"setmealname":"关爱女性妇科套餐二","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA295.png","crowd":"4","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"430","lng":"114.608288","lat":"38.01946","setmealid":"15637007762622931"},{"setmealname":"关爱女性妇科套餐三","setmealprice":"0.01","setmealpic":"http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA295.png","crowd":"4","mechaddress":"河北省石家庄市长安区广安大街时代方舟C座 四、五层","mechname":"长城体检中心","setmealprices":"1011","lng":"114.608288","lat":"38.01946","setmealid":"15637007823510456"}]
     * method : getphysicallist
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<PhysicallistBean> physicallist;

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

    public List<PhysicallistBean> getPhysicallist() {
        return physicallist;
    }

    public void setPhysicallist(List<PhysicallistBean> physicallist) {
        this.physicallist = physicallist;
    }

    public static class PhysicallistBean {
        /**
         * setmealname : 初入职场套餐二
         * setmealprice : 0.01
         * setmealpic : http://192.168.1.166:8889/img/1556529219429763556-D85C493FAF940FB79A4DCAAB7F9AA291.png
         * crowd : 5
         * mechaddress : 河北省石家庄市长安区广安大街时代方舟C座 四、五层
         * mechname : 长城体检中心
         * setmealprices : 245
         * lng : 114.608288
         * lat : 38.01946
         * setmealid : 15637006780341589
         */

        private String setmealname;
        private String setmealprice;
        private String setmealpic;
        private String crowd;
        private String mechaddress;
        private String mechname;
        private String setmealprices;
        private String lng;
        private String lat;
        private String setmealid;

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

        public String getSetmealpic() {
            return setmealpic;
        }

        public void setSetmealpic(String setmealpic) {
            this.setmealpic = setmealpic;
        }

        public String getCrowd() {
            return crowd;
        }

        public void setCrowd(String crowd) {
            this.crowd = crowd;
        }

        public String getMechaddress() {
            return mechaddress;
        }

        public void setMechaddress(String mechaddress) {
            this.mechaddress = mechaddress;
        }

        public String getMechname() {
            return mechname;
        }

        public void setMechname(String mechname) {
            this.mechname = mechname;
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

        public String getSetmealid() {
            return setmealid;
        }

        public void setSetmealid(String setmealid) {
            this.setmealid = setmealid;
        }

        @Override
        public String toString() {
            return "PhysicallistBean{" +
                    "setmealname='" + setmealname + '\'' +
                    ", setmealprice='" + setmealprice + '\'' +
                    ", setmealpic='" + setmealpic + '\'' +
                    ", crowd='" + crowd + '\'' +
                    ", mechaddress='" + mechaddress + '\'' +
                    ", mechname='" + mechname + '\'' +
                    ", setmealprices='" + setmealprices + '\'' +
                    ", lng='" + lng + '\'' +
                    ", lat='" + lat + '\'' +
                    ", setmealid='" + setmealid + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PhysicalListBean{" +
                "repcode='" + repcode + '\'' +
                ", repmsg='" + repmsg + '\'' +
                ", method='" + method + '\'' +
                ", physicallist=" + physicallist +
                '}';
    }
}
