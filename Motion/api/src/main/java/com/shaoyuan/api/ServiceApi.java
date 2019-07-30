package com.shaoyuan.api;

import com.shaoyuan.model.healthdataBean.ADIMessageBean;
import com.shaoyuan.model.healthdataBean.ConsumeHealthyDataBean;
import com.shaoyuan.model.healthdataBean.ConsumeTypeBean;
import com.shaoyuan.model.healthdataBean.DeleteOneFoodBean;
import com.shaoyuan.model.healthdataBean.EnergyConsumeBean;
import com.shaoyuan.model.healthdataBean.IntakeFoodBean;
import com.shaoyuan.model.healthdataBean.MakePhysicalBean;
import com.shaoyuan.model.healthdataBean.PhysicalResultsBean;
import com.shaoyuan.model.healthdataBean.SaveAllFoodBean;
import com.shaoyuan.model.healthdataBean.SaveDiseaseNameBean;
import com.shaoyuan.model.healthdataBean.SaveStaminaAnswerBean;
import com.shaoyuan.model.healthdataBean.SaveStaminaResultBean;
import com.shaoyuan.model.healthdataBean.SaveSumIntakeBean;
import com.shaoyuan.model.healthdataBean.SaveUserFoodBean;
import com.shaoyuan.model.healthdataBean.SelectConsumeTypeBean;
import com.shaoyuan.model.healthdataBean.UploadingPhysicalBean;
import com.shaoyuan.model.healthdataBean.UploadingStaminaAnswerBean;
import com.shaoyuan.model.healthdataBean.UserConsumeIntakeBean;
import com.shaoyuan.model.personalBean.FAQBean;
import com.shaoyuan.model.personalBean.FeedbackBean;
import com.shaoyuan.model.personalBean.HeadImgBean;
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

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by small-ho on 2019/7/2 13:47
 * title：Api层
 */
public interface ServiceApi {

    /**
     * 注册
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<RegisterBean> getRegister(@Body RequestBody requestBody);

    /**
     * 登录
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<LoginBean> getLogin(@Body RequestBody requestBody);

    /**
     * 获取短信验证码
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<ShowVerificationBean> getShowVerification(@Body RequestBody requestBody);

    /**
     * 验证短信验证码
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<VerificationCodeBean> getVerificationCode(@Body RequestBody requestBody);

    /**
     * 修改密码
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<UpPasswordBean> getUpPassword(@Body RequestBody requestBody);

    /**
     * 修改个人资料
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<UpdateDataBean> getUpdateData(@Body RequestBody requestBody);

    /**
     * 获取个人资料
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<ShowDataBean> getShowData(@Body RequestBody requestBody);

    /**
     * 获取头像
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<HeadImgBean> getHeadImg(@Body RequestBody requestBody);

    /**
     * 修改/上传头像
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<UpHeadImgBean> getUpHeadImg(@Body RequestBody requestBody);

    /**
     * 意见反馈
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<FeedbackBean> getFeedback(@Body RequestBody requestBody);

    /**
     * 常见问题
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<FAQBean> getFAQ(@Body RequestBody requestBody);

    /**
     * 体检列表
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<PhysicalListBean> getPhysicalList(@Body RequestBody requestBody);

    /**
     * 体检详情
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<PhysicalDetailsBean> getPhysicalDetails(@Body RequestBody requestBody);

    /**
     * 返回消耗具体类型信息
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<ConsumeTypeBean> getConsumeType(@Body RequestBody requestBody);

    /**
     * 用户查看当前食物摄入信息
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<IntakeFoodBean> getIntakeFood(@Body RequestBody requestBody);

    /**
     * 返回消耗类型让用户选择
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<SelectConsumeTypeBean> getSelectConsumeType(@Body RequestBody requestBody);

    /**
     * 删除单条食物信息
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<DeleteOneFoodBean> getDeleteOneFood(@Body RequestBody requestBody);

    /**
     * 能量消耗信息展示
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<EnergyConsumeBean> getEnergyConsume(@Body RequestBody requestBody);

    /**
     * 摄入量信息展示
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<ADIMessageBean> getADIMessage(@Body RequestBody requestBody);

    /**
     * 保存用户食物摄入信息
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<SaveUserFoodBean> getSaveUserFood(@Body RequestBody requestBody);

    /**
     * 获取当天消耗健康数据报告
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<ConsumeHealthyDataBean> getConsumeHealthyData(@Body RequestBody requestBody);

    /**
     * 获取用户当天的总消耗和总摄入
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<UserConsumeIntakeBean> getUserConsumeIntake(@Body RequestBody requestBody);

    /**
     * 获取所有事食物信息
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<SaveAllFoodBean> getSaveAllFood(@Body RequestBody requestBody);

    /**
     * 获取当天总摄入健康数据报告
     * @param requestBody
     * @return
     */
    @POST("healthy")
    Observable<SaveSumIntakeBean> getSavaSumIntake(@Body RequestBody requestBody);

    /**
     * 获取疾病名
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<SaveDiseaseNameBean> getSaveDiseaseName(@Body RequestBody requestBody);

    /**
     * 获取体质检测结果
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<PhysicalResultsBean> getPhysicalResults(@Body RequestBody requestBody);

    /**
     * 上传 体质检测报告
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<UploadingPhysicalBean> getUploadingPhysical(@Body RequestBody requestBody);

    /**
     * 上传体能问卷答案
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<UploadingStaminaAnswerBean> getUploadingStaminaAnswer(@Body RequestBody requestBody);

    /**
     * 获取体能问卷问题和答案
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<SaveStaminaAnswerBean> getSaveStaminaAnswer(@Body RequestBody requestBody);

    /**
     * 获取体能检测结果
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<SaveStaminaResultBean> getSaveStaminaResult(@Body RequestBody requestBody);

    /**
     * 预约体能/体质检测
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<MakePhysicalBean> getMakePhysical(@Body RequestBody requestBody);

    /**
     * 预约体检
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<MakeAnPhysicalBean> getMakeAnPhysical(@Body RequestBody requestBody);

    /**
     * 获取体检报告
     * @param requestBody
     * @return
     */
    @POST("personal")
    Observable<SavePhysicalReportBean> getSavePhysicalReport(@Body RequestBody requestBody);
}
