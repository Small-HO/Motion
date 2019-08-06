package com.shaoyuan.model.dataModel;

/**
 * Created by small-ho on 2019/8/6 15:55
 * title：微信数据模型
 */
public class AdwxpayModel {

    /**
     * adwxpay : {'prepayid': 'wx061715521572731950ffd66c1132427900', 'appid': 'wxd2830b3bf1d51218', 'partnerid': '1536563211', 'noncestr': 'hl7ga6h3l3jhbiidtd913bt8zutnmy8k', 'timestamp': '1565082956', 'package': 'Sign=WXPay', 'sign': 'F9E65A5E41472F91F5D4BF1DA83B2934', 'repcode': '00', 'repmsg': '获取成功'}
     * paytype : 2
     * method : paymode
     */

    private String adwxpay;
    private String paytype;
    private String method;

    public String getAdwxpay() {
        return adwxpay;
    }

    public void setAdwxpay(String adwxpay) {
        this.adwxpay = adwxpay;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "AdwxpayModel{" +
                "adwxpay='" + adwxpay + '\'' +
                ", paytype='" + paytype + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
