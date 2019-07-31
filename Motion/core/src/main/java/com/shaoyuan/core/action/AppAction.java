package com.shaoyuan.core.action;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.model.healthdataBean.ADIMessageBean;
import com.shaoyuan.model.healthdataBean.ConsumeHealthyDataBean;
import com.shaoyuan.model.healthdataBean.ConsumeTypeBean;
import com.shaoyuan.model.healthdataBean.CourseBookingBean;
import com.shaoyuan.model.healthdataBean.DeleteOneFoodBean;
import com.shaoyuan.model.healthdataBean.EnergyConsumeBean;
import com.shaoyuan.model.healthdataBean.EquipmentBookingBean;
import com.shaoyuan.model.healthdataBean.EquipmentMakeDateBean;
import com.shaoyuan.model.healthdataBean.HistoryPhysicalDateBean;
import com.shaoyuan.model.healthdataBean.IntakeFoodBean;
import com.shaoyuan.model.healthdataBean.MakePhysicalBean;
import com.shaoyuan.model.healthdataBean.PhysicalResultsBean;
import com.shaoyuan.model.healthdataBean.SaveAllFoodBean;
import com.shaoyuan.model.healthdataBean.SaveDiseaseListBean;
import com.shaoyuan.model.healthdataBean.SaveDiseaseNameBean;
import com.shaoyuan.model.healthdataBean.SavePhysicalListBean;
import com.shaoyuan.model.healthdataBean.SaveStaminaAnswerBean;
import com.shaoyuan.model.healthdataBean.SaveStaminaResultBean;
import com.shaoyuan.model.healthdataBean.SaveSumIntakeBean;
import com.shaoyuan.model.healthdataBean.SaveUserFoodBean;
import com.shaoyuan.model.healthdataBean.SaveUserSportBean;
import com.shaoyuan.model.healthdataBean.SelectConsumeTypeBean;
import com.shaoyuan.model.healthdataBean.SportsCenterBean;
import com.shaoyuan.model.healthdataBean.UploadingPhysicalBean;
import com.shaoyuan.model.healthdataBean.UploadingStaminaAnswerBean;
import com.shaoyuan.model.healthdataBean.UserConsumeIntakeBean;
import com.shaoyuan.model.healthdataBean.VenueBookingBean;
import com.shaoyuan.model.healthdataBean.VenueMakeDateBean;
import com.shaoyuan.model.personalBean.FAQBean;
import com.shaoyuan.model.personalBean.FeedbackBean;
import com.shaoyuan.model.personalBean.HeadImgBean;
import com.shaoyuan.model.personalBean.HomePageBean;
import com.shaoyuan.model.personalBean.LoginBean;
import com.shaoyuan.model.personalBean.MakeAnPhysicalBean;
import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.model.personalBean.PhysicalListBean;
import com.shaoyuan.model.personalBean.RegisterBean;
import com.shaoyuan.model.personalBean.SavePhysicalReportBean;
import com.shaoyuan.model.personalBean.ShowDataBean;
import com.shaoyuan.model.personalBean.ShowVerificationBean;
import com.shaoyuan.model.personalBean.UpHeadImgBean;
import com.shaoyuan.model.personalBean.UpPasswordBean;
import com.shaoyuan.model.personalBean.UpdateDataBean;
import com.shaoyuan.model.personalBean.VerificationCodeBean;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 13:38
 * title：核心层，向下调用Api，向上提供Action，介于api与app之间
 */
public interface AppAction {

    //注册
    void register(Map<String,Object> params, HttpCallback<RegisterBean> callback);

    //登录
    void login(Map<String,Object> params, HttpCallback<LoginBean> callback);

    //获取短信验证码
    void showVerification(Map<String,Object> params, HttpCallback<ShowVerificationBean> callback);

    //验证短信验证码
    void verificationCode(Map<String,Object> params, HttpCallback<VerificationCodeBean> callback);

    //修改密码
    void uppassword(Map<String,Object> params, HttpCallback<UpPasswordBean> callback);

    //修改个人资料
    void updateData(Map<String,Object> params, HttpCallback<UpdateDataBean> callback);

    //获取个人资料
    void showData(Map<String,Object> params, HttpCallback<ShowDataBean> callback);

    //获取头像
    void headImg(Map<String,Object> params, HttpCallback<HeadImgBean> callback);

    //修改/上传头像
    void upheadImg(Map<String,Object> params, HttpCallback<UpHeadImgBean> callback);

    //意见反馈
    void feedback(Map<String,Object> params, HttpCallback<FeedbackBean> callback);

    //常见问题
    void FAQ(Map<String,Object> params, HttpCallback<FAQBean> callback);

    //体检列表
    void physicalList(Map<String,Object> params, HttpCallback<PhysicalListBean> callback);

    //体检详情
    void physicalDetails(Map<String,Object> params, HttpCallback<PhysicalDetailsBean> callback);

    //返回消耗具体类型信息
    void consumeType(Map<String,Object> params, HttpCallback<ConsumeTypeBean> callback);

    //用户查看当天食物摄入信息
    void intakeFood(Map<String,Object> params, HttpCallback<IntakeFoodBean> callback);

    //返回消耗类型让用户选择
    void selectConsumeType(Map<String,Object> params, HttpCallback<SelectConsumeTypeBean> callback);

    //删除单条食物信息
    void deleteOneFood(Map<String,Object> params, HttpCallback<DeleteOneFoodBean> callback);

    //能量消耗信息展示
    void energyConsume(Map<String,Object> params, HttpCallback<EnergyConsumeBean> callback);

    //摄入量信息展示
    void ADIMessage(Map<String,Object> params, HttpCallback<ADIMessageBean> callback);

    //保存用户食物摄入信息
    void saveUserFood(Map<String,Object> params, HttpCallback<SaveUserFoodBean> callback);

    //获取当天消耗健康数据报告
    void consumeHealthyData(Map<String,Object> params, HttpCallback<ConsumeHealthyDataBean> callback);

    //获取用户当天的总消耗和总摄入
    void userConsumeIntake(Map<String,Object> params, HttpCallback<UserConsumeIntakeBean> callback);

    //获取所有食物信息
    void SaveAllFood(Map<String,Object> params, HttpCallback<SaveAllFoodBean> callback);

    //获取当天总摄入健康数据报告
    void saveSumIntake(Map<String,Object> params, HttpCallback<SaveSumIntakeBean> callback);

    //获取疾病名
    void saveDiseaseName(Map<String,Object> params, HttpCallback<SaveDiseaseNameBean> callback);

    //获取体质检测结果
    void physicalResults(Map<String,Object> params, HttpCallback<PhysicalResultsBean> callback);

    //上传体质检测报告
    void uploadingPhysical(Map<String,Object> params, HttpCallback<UploadingPhysicalBean> callback);

    //上传体能问卷答案
    void uploadingStaminaAnswer(Map<String,Object> params, HttpCallback<UploadingStaminaAnswerBean> callback);

    //获取体能问卷问题和答案
    void saveStaminaAnswer(Map<String,Object> params, HttpCallback<SaveStaminaAnswerBean> callback);

    //获取体能检测结果
    void saveStaminaResult(Map<String,Object> params, HttpCallback<SaveStaminaResultBean> callback);

    //预约体能/体质检测
    void makePhysical(Map<String,Object> params, HttpCallback<MakePhysicalBean> callback);

    //预约体检
    void makeAnPhysical(Map<String,Object> params, HttpCallback<MakeAnPhysicalBean> callback);

    //获取体检报告
    void savePhysicalReport(Map<String,Object> params, HttpCallback<SavePhysicalReportBean> callback);

    //获取体能/体质机构测试列表
    void savePhysicalList(Map<String,Object> params, HttpCallback<SavePhysicalListBean> callback);

    //获取疾病/人群标签列表
    void saveDiseaseList(Map<String,Object> params, HttpCallback<SaveDiseaseListBean> callback);

    //保存用户户外运动信息
    void saveUserSport(Map<String,Object> params, HttpCallback<SaveUserSportBean> callback);

    //获取历史体质/体能/病历日期
    void historyPhysicalDate(Map<String,Object> params, HttpCallback<HistoryPhysicalDateBean> callback);

    //运动中心
    void sportsCenter(Map<String,Object> params, HttpCallback<SportsCenterBean> callback);

    //课程预约
    void courseBooking(Map<String,Object> params, HttpCallback<CourseBookingBean> callback);

    //器材预约
    void equipmentBooking(Map<String,Object> params, HttpCallback<EquipmentBookingBean> callback);

    //场地预约
    void venueBooking(Map<String,Object> params, HttpCallback<VenueBookingBean> callback);

    //器材可预约时间段
    void equipmentMakeDate(Map<String,Object> params, HttpCallback<EquipmentMakeDateBean> callback);

    //场地可预约时间段
    void venueMakeDate(Map<String,Object> params, HttpCallback<VenueMakeDateBean> callback);

    //首页
    void homePage(Map<String,Object> params, HttpCallback<HomePageBean> callback);




 /*   //  发送验证码
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
    void reportsAnalyses(Map<String,Object> params, HttpCallback<DataReportModel> callback);*/
}
