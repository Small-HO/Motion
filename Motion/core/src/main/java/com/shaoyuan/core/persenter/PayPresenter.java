package com.shaoyuan.core.persenter;

import android.content.Context;

import com.google.gson.JsonObject;
import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.PayInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.core.utils.MyToast;
import com.shaoyuan.core.utils.SharedPreferencesUtils;
import com.shaoyuan.model.dataModel.AdwxpayModel;
import com.shaoyuan.net.HttpCallback;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by small-ho on 2019/8/6 15:04
 * title：
 */
public class PayPresenter implements PayInterface.presenter {
    private PayInterface.view view;
    private AppAction action;

    private IWXAPI mWxApi;

    public PayPresenter(PayInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void alipay() {

    }

    @Override
    public void wxpay() {
        mWxApi = WXAPIFactory.createWXAPI(view.getContext(), view.getAppid(),false);
        mWxApi.registerApp(view.getAppid());

        if (mWxApi.isWXAppInstalled()) {
            action.userPay(params(), new HttpCallback<AdwxpayModel>() {
                @Override
                public void onSuccesss(AdwxpayModel result) {
                    view.showLog("微信支付返回：" + result.toString());
                    String repcode = getjsonitem(result.getAdwxpay(), "repcode");
                    if (repcode.equals("00")) {
                        PayReq req = new PayReq();
                        String appid = getjsonitem(result.getAdwxpay(), "appid");
                        String partnerId = getjsonitem(result.getAdwxpay(), "partnerId");
                        String prepayId = getjsonitem(result.getAdwxpay(), "prepayId");
                        String aPackage = getjsonitem(result.getAdwxpay(), "package");
                        String nonceStr = getjsonitem(result.getAdwxpay(), "nonceStr");
                        String timeStamp = getjsonitem(result.getAdwxpay(), "timeStamp");
                        String sign = getjsonitem(result.getAdwxpay(), "sign");

                        req.appId       = appid;
                        req.partnerId   = partnerId;
                        req.prepayId    = prepayId;
                        req.packageValue= aPackage;
                        req.nonceStr    = nonceStr;
                        req.timeStamp   = timeStamp;
                        req.sign        = sign;
                        mWxApi.sendReq(req);
                    }
                }

                @Override
                public void onFailures(String erro) {

                }
            });
        }else {
            MyToast.showToast(view.getContext(),"请先下载微信客户端");
        }
    }

    private Map<String, Object> params() {
        Map<String,Object> params = new HashMap<>();
        params.put("method","paymode");
        params.put("paytype","2");
        params.put("recordid", SharedPreferencesUtils.getString(view.getContext(), Constants.recordid,""));
        params.put("subject",SharedPreferencesUtils.getString(view.getContext(),Constants.subject,""));
        params.put("price",SharedPreferencesUtils.getString(view.getContext(),Constants.price,""));
        view.showLog("支付订单所需参数" + params);
        return params;
    }

    @Override
    public void pay() {

    }

    public static String getjsonitem(String Json, String item) {
        try {
            JSONObject jsonObject = new JSONObject(Json);
            return jsonObject.optString(item);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Json;
    }
}
