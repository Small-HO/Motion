package com.shaoyuan.core.actionImpl;

import android.content.Context;

import com.shaoyuan.api.ServiceApi;
import com.shaoyuan.api.ServiceApiImpl;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataInfo.DataReportInfo;
import com.shaoyuan.model.dataInfo.OrderInfo;
import com.shaoyuan.model.dataInfo.QuestionInfo;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.net.HttpCallback;
import com.shaoyuan.net.HttpHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 13:45
 * title：核心层实现类
 */
public class AppActionImpl implements AppAction {
    private final static int LOGIN_OS = 1;      //  表示Android
    private final static int PAGE_SIZE = 20;    //  默认每页20条

    private Context context;
    private ServiceApi api;

    public AppActionImpl(Context context){
        this.context = context;
        this.api = new ServiceApiImpl();
    }

    @Override
    public void sendSmsCode(Map<String, Object> params, final HttpCallback<SmsCode> callback) {
        //  参数为空检查
        if (params == null && params.isEmpty()) {
            if (callback != null) {
                callback.onFailure("参数为空");
            }
            return;
        }
        if (params.get("telno") == null && params.get("telno").equals("")) {
            if (callback != null) {
                callback.onFailure("手机号为空");
            }
            return;
        }

        //  手机号校验

        //  网络请求
        HttpHelper.getInstance().post(api.personal("personal"), params, new HttpCallback<SmsCode>() {
            @Override
            public void onFailure(String e) {

            }

            @Override
            public void onSuccess(SmsCode smsCode) {
                callback.onSuccess(smsCode.toString());
            }
        });
    }

    @Override
    public void orderInfo(Map<String, Object> params, HttpCallback<OrderModel> callback) {
        //  模拟数据
        OrderModel model = new OrderModel();
        List<OrderInfo> list = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setTemstype("场地");
        info.setSetmealprice("0.01");
        info.setPaystate(false);
        info.setCreattime("2019-07-15 09:13:57");
        info.setMechname("团操室");
        list.add(info);
        model.setOrderInfos(list);

        callback.onSuccess(model);
    }

    @Override
    public void userInfo(Map<String, Object> params, HttpCallback<UserInfoModel> callback) {
        //  模拟数据
        UserInfoModel model = new UserInfoModel();
        model.setNickname("小油瓶");
        model.setSex("女");
        model.setBirthdate("2019");
        model.setHeight("1.8");
        model.setWeight("145");

        callback.onSuccess(model);
    }

    @Override
    public void userInfoSave(Map<String, Object> params, HttpCallback<BaseModel> callback) {
        //  模拟数据
        BaseModel model = new BaseModel();

        callback.onSuccess(model);
    }

    @Override
    public void updatePas(Map<String, Object> params, HttpCallback<BaseModel> callback) {
        //  模拟数据
        BaseModel model = new BaseModel();

        callback.onSuccess(model);
    }

    @Override
    public void questions(Map<String, Object> params, HttpCallback<QuestionModel> callback) {
        //  模拟数据
        QuestionModel model = new QuestionModel();
        List<QuestionInfo> list = new ArrayList<>();
        QuestionInfo info = new QuestionInfo();

        info.setComname("测试标题数据");
        info.setSpoexpain("测试标题文本");
        list.add(info);
        model.setInfos(list);

        callback.onSuccess(model);
    }

    @Override
    public void suggestionSubmit(Map<String, Object> params, HttpCallback<BaseModel> callback) {
        //  模拟数据
        BaseModel model = new BaseModel();

        callback.onSuccess(model);
    }

    @Override
    public void countconTody(Map<String, Object> params, HttpCallback<CountcontodayModel> callback) {
        //  模拟数据
        CountcontodayModel model = new CountcontodayModel();


        callback.onSuccess(model);
    }

    @Override
    public void reportsAnalyses(Map<String, Object> params, HttpCallback<DataReportModel> callback) {
        //  模拟数据
        DataReportModel model = new DataReportModel();
        List<DataReportInfo> infos = new ArrayList<>();
        DataReportInfo info = new DataReportInfo();

        info.setConmany("工作");  //  工作
        info.setContime("10");
        info.setContype("10");
        info.setFoodh("10");

        infos.add(info);
        model.setGetdata(infos);

        callback.onSuccess(model);
    }
}
