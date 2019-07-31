package com.shaoyuan.core.actionImpl;

import android.content.Context;

import com.google.gson.Gson;
import com.shaoyuan.api.ServiceApi;
import com.shaoyuan.api.ServiceApiImpl;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.SmsCode;
import com.shaoyuan.model.dataInfo.DataReportInfo;
import com.shaoyuan.model.dataInfo.IllnessInfo;
import com.shaoyuan.model.dataInfo.OrderInfo;
import com.shaoyuan.model.dataInfo.QuestionInfo;
import com.shaoyuan.model.dataInfo.WorkInfo;
import com.shaoyuan.model.dataModel.CountcontodayModel;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.model.dataModel.IllnessModel;
import com.shaoyuan.model.dataModel.OrderModel;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.model.dataModel.ScreenModel;
import com.shaoyuan.model.dataModel.UserInfoModel;
import com.shaoyuan.model.dataModel.WorkModel;
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
import com.shaoyuan.net.HttpHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
        //this.api = new ServiceApiImpl();
    }

    @Override
    public void register(Map<String, Object> params, HttpCallback<RegisterBean> callback) {

    }

    @Override
    public void login(Map<String, Object> params, HttpCallback<LoginBean> callback) {

    }

    @Override
    public void showVerification(Map<String, Object> params, HttpCallback<ShowVerificationBean> callback) {

    }

    @Override
    public void verificationCode(Map<String, Object> params, HttpCallback<VerificationCodeBean> callback) {

    }

    @Override
    public void upPassword(Map<String, Object> params, HttpCallback<UpPasswordBean> callback) {

    }

    @Override
    public void updateData(Map<String, Object> params, HttpCallback<UpdateDataBean> callback) {

    }

    @Override
    public void showData(Map<String, Object> params, HttpCallback<ShowDataBean> callback) {

    }

    @Override
    public void headImg(Map<String, Object> params, HttpCallback<HeadImgBean> callback) {

    }

    @Override
    public void upHeadImg(Map<String, Object> params, HttpCallback<UpHeadImgBean> callback) {

    }

    @Override
    public void feedback(Map<String, Object> params, final HttpCallback<FeedbackBean> callback) {
        Gson gson=new Gson();
        String s = gson.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);
        ServiceApiImpl.getInstance().getFeedback(requestBody).subscribe(new Observer<FeedbackBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FeedbackBean feedbackBean) {
                callback.onSuccess(feedbackBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void FAQ(Map<String, Object> params, HttpCallback<FAQBean> callback) {

    }

    @Override
    public void physicalList(Map<String, Object> params, HttpCallback<PhysicalListBean> callback) {

    }

    @Override
    public void physicalDetails(Map<String, Object> params, HttpCallback<PhysicalDetailsBean> callback) {

    }

    @Override
    public void consumeType(Map<String, Object> params, HttpCallback<ConsumeTypeBean> callback) {

    }

    @Override
    public void intakeFood(Map<String, Object> params, HttpCallback<IntakeFoodBean> callback) {

    }

    @Override
    public void selectConsumeType(Map<String, Object> params, HttpCallback<SelectConsumeTypeBean> callback) {

    }

    @Override
    public void deleteOneFood(Map<String, Object> params, HttpCallback<DeleteOneFoodBean> callback) {

    }

    @Override
    public void energyConsume(Map<String, Object> params, HttpCallback<EnergyConsumeBean> callback) {

    }

    @Override
    public void ADIMessage(Map<String, Object> params, HttpCallback<ADIMessageBean> callback) {

    }

    @Override
    public void saveUserFood(Map<String, Object> params, HttpCallback<SaveUserFoodBean> callback) {

    }

    @Override
    public void consumeHealthyData(Map<String, Object> params, HttpCallback<ConsumeHealthyDataBean> callback) {

    }

    @Override
    public void userConsumeIntake(Map<String, Object> params, HttpCallback<UserConsumeIntakeBean> callback) {

    }

    @Override
    public void saveAllFood(Map<String, Object> params, HttpCallback<SaveAllFoodBean> callback) {

    }

    @Override
    public void savaSumIntake(Map<String, Object> params, HttpCallback<SaveSumIntakeBean> callback) {

    }

    @Override
    public void saveDiseaseName(Map<String, Object> params, HttpCallback<SaveDiseaseNameBean> callback) {

    }

    @Override
    public void physicalResults(Map<String, Object> params, HttpCallback<PhysicalResultsBean> callback) {

    }

    @Override
    public void uploadingPhysical(Map<String, Object> params, HttpCallback<UploadingPhysicalBean> callback) {

    }

    @Override
    public void uploadingStaminaAnswer(Map<String, Object> params, HttpCallback<UploadingStaminaAnswerBean> callback) {

    }

    @Override
    public void saveStaminaAnswer(Map<String, Object> params, HttpCallback<SaveStaminaAnswerBean> callback) {

    }

    @Override
    public void saveStaminaResult(Map<String, Object> params, HttpCallback<SaveStaminaResultBean> callback) {

    }

    @Override
    public void makePhysical(Map<String, Object> params, HttpCallback<MakePhysicalBean> callback) {

    }

    @Override
    public void makeAnPhysical(Map<String, Object> params, HttpCallback<MakeAnPhysicalBean> callback) {

    }

    @Override
    public void savePhysicalReport(Map<String, Object> params, HttpCallback<SavePhysicalReportBean> callback) {

    }

    @Override
    public void savePhysicalList(Map<String, Object> params, HttpCallback<SavePhysicalListBean> callback) {

    }

    @Override
    public void saveDiseaseList(Map<String, Object> params, HttpCallback<SaveDiseaseListBean> callback) {

    }

    @Override
    public void saveUserSport(Map<String, Object> params, HttpCallback<SaveUserSportBean> callback) {

    }

    @Override
    public void historyPhysicalDate(Map<String, Object> params, HttpCallback<HistoryPhysicalDateBean> callback) {

    }

    @Override
    public void sportsCenter(Map<String, Object> params, HttpCallback<SportsCenterBean> callback) {

    }

    @Override
    public void courseBooking(Map<String, Object> params, HttpCallback<CourseBookingBean> callback) {

    }

    @Override
    public void equipmentBooking(Map<String, Object> params, HttpCallback<EquipmentBookingBean> callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), params.toString());
    }

    @Override
    public void venueBooking(Map<String, Object> params, HttpCallback<VenueBookingBean> callback) {

    }

    @Override
    public void equipmentMakeDate(Map<String, Object> params, HttpCallback<EquipmentMakeDateBean> callback) {

    }

    @Override
    public void venueMakeDate(Map<String, Object> params, HttpCallback<VenueMakeDateBean> callback) {

    }

    @Override
    public void homePage(Map<String, Object> params, HttpCallback<HomePageBean> callback) {

    }

    /*@Override
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

    @Override
    public void sceenList(Map<String, Object> params, HttpCallback<ScreenModel> callback) {
        //  模拟数据



    }

    @Override
    public void crowdList(Map<String, Object> params, HttpCallback<IllnessModel> callback) {
        //  模拟数据
        IllnessModel model = new IllnessModel();
        List<IllnessInfo> list = new ArrayList<>();
        IllnessInfo info = new IllnessInfo();

        for (int i = 0; i < 11; i++) {
            info.setItem("测试");
            list.add(info);
        }

        model.setList(list);
        callback.onSuccess(model);
    }

    @Override
    public void illnessList(Map<String, Object> params, HttpCallback<IllnessModel> callback) {
        //  模拟数据
        IllnessModel model = new IllnessModel();
        List<IllnessInfo> list = new ArrayList<>();
        IllnessInfo info = new IllnessInfo();

        for (int i = 0; i < 11; i++) {
            info.setItem("测试");
            list.add(info);
        }

        model.setList(list);
        callback.onSuccess(model);
    }

    @Override
    public void addWorkConsume(Map<String, Object> params, HttpCallback<WorkModel> callback) {
        WorkModel model = new WorkModel();
        List<WorkInfo> infos = new ArrayList<>();
        WorkInfo info = new WorkInfo();

        for (int i = 0; i < 3; i++) {

            info.setTypenamee("介绍");
            infos.add(info);
        }

        model.setGetdata(infos);


        callback.onSuccess(model);
    }*/
}
