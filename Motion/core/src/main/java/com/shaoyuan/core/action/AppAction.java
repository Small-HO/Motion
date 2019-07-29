package com.shaoyuan.core.action;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataInfo.IllnessInfo;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.model.dataModel.IllnessModel;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.model.dataModel.ScreenModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.model.dataModel.WorkModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 13:38
 * title：核心层，向下调用Api，向上提供Action，介于api与app之间
 */
public interface AppAction {
//    void login(Map<String,Object> params, HttpCallback<> callback);
    //  发送验证码
    void sendSmsCode(Map<String,Object> params, HttpCallback<SmsCode> callback);

    //  订单列表
    void orderInfo(Map<String,Object> params, HttpCallback<OrderModel> callback);

    //  用户基本信息
    void userInfo(Map<String,Object> params, HttpCallback<UserInfoModel> callback);
    //  保存用户信息
    void userInfoSave(Map<String,Object> params, HttpCallback<BaseModel> callback);

    //  修改密码
    void updatePas(Map<String,Object> params,HttpCallback<BaseModel> callback);

    //  常见问题
    void questions(Map<String,Object> params, HttpCallback<QuestionModel> callback);

    //  提交意见反馈信息
    void suggestionSubmit(Map<String,Object> params,HttpCallback<BaseModel> callback);

    //  消耗摄入
    void countconTody(Map<String,Object> params, HttpCallback<CountcontodayModel> callback);

    //  报告分析
    void reportsAnalyses(Map<String,Object> params, HttpCallback<DataReportModel> callback);


    /** ------------------------------------- 首页 ---------------------------------------*/

    //  健康体检列表
    void sceenList(Map<String,Object> params, HttpCallback<ScreenModel> callback);
    //  适用人群
    void crowdList(Map<String,Object> params, HttpCallback<IllnessModel> callback);
    //  高发疾病
    void illnessList(Map<String,Object> params,HttpCallback<IllnessModel> callback);



    /** 消耗摄入部位 */
    //  添加工作
    void addWorkConsume(Map<String,Object> params, HttpCallback<WorkModel> callback);

}
