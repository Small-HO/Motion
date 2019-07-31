package com.shaoyuan.api;

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

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by small-ho on 2019/7/2 13:47
 * title：
 */
public class ServiceApiImpl implements ServiceApi {

    public final static String HttpUrl = "http://192.168.1.166:8889/";

    private Retrofit mRetrofit;
    private static ServiceApiImpl instance;
    public static OkHttpClient mOkClient;

    private ServiceApiImpl() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (L.isPrint) {
            builder.addInterceptor(interceptor);
        }


        mOkClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkClient)
                .build();
    }

    public static ServiceApiImpl getInstance() {
        if (instance == null) {
            synchronized (ServiceApiImpl.class) {
                if (instance == null) {
                    instance = new ServiceApiImpl();
                }
            }
        }
        return instance;
    }

    public <T> T createApi(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }


    public ServiceApi getFixApid() {
        return mRetrofit.create(ServiceApi.class);
    }



    @Override
    public Observable<RegisterBean> getRegister(RequestBody requestBody) {
        return getFixApid()
                .getRegister(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<LoginBean> getLogin(RequestBody requestBody) {
        return getFixApid()
                .getLogin(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ShowVerificationBean> getShowVerification(RequestBody requestBody) {
        return getFixApid()
                .getShowVerification(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<VerificationCodeBean> getVerificationCode(RequestBody requestBody) {
        return getFixApid()
                .getVerificationCode(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UpPasswordBean> getUpPassword(RequestBody requestBody) {
        return getFixApid()
                .getUpPassword(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UpdateDataBean> getUpdateData(RequestBody requestBody) {
        return getFixApid()
                .getUpdateData(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ShowDataBean> getShowData(RequestBody requestBody) {
        return getFixApid()
                .getShowData(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<HeadImgBean> getHeadImg(RequestBody requestBody) {
        return getFixApid()
                .getHeadImg(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UpHeadImgBean> getUpHeadImg(RequestBody requestBody) {
        return getFixApid()
                .getUpHeadImg(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<FeedbackBean> getFeedback(RequestBody requestBody) {
        return getFixApid()
                .getFeedback(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<FAQBean> getFAQ(RequestBody requestBody) {
        return getFixApid()
                .getFAQ(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PhysicalListBean> getPhysicalList(RequestBody requestBody) {
        return getFixApid()
                .getPhysicalList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PhysicalDetailsBean> getPhysicalDetails(RequestBody requestBody) {
        return getFixApid()
                .getPhysicalDetails(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ConsumeTypeBean> getConsumeType(RequestBody requestBody) {
        return getFixApid()
                .getConsumeType(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<IntakeFoodBean> getIntakeFood(RequestBody requestBody) {
        return getFixApid()
                .getIntakeFood(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SelectConsumeTypeBean> getSelectConsumeType(RequestBody requestBody) {
        return getFixApid()
                .getSelectConsumeType(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<DeleteOneFoodBean> getDeleteOneFood(RequestBody requestBody) {
        return getFixApid()
                .getDeleteOneFood(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<EnergyConsumeBean> getEnergyConsume(RequestBody requestBody) {
        return getFixApid()
                .getEnergyConsume(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ADIMessageBean> getADIMessage(RequestBody requestBody) {
        return getFixApid()
                .getADIMessage(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveUserFoodBean> getSaveUserFood(RequestBody requestBody) {
        return getFixApid()
                .getSaveUserFood(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ConsumeHealthyDataBean> getConsumeHealthyData(RequestBody requestBody) {
        return getFixApid()
                .getConsumeHealthyData(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UserConsumeIntakeBean> getUserConsumeIntake(RequestBody requestBody) {
        return getFixApid()
                .getUserConsumeIntake(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveAllFoodBean> getSaveAllFood(RequestBody requestBody) {
        return getFixApid()
                .getSaveAllFood(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveSumIntakeBean> getSavaSumIntake(RequestBody requestBody) {
        return getFixApid()
                .getSavaSumIntake(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveDiseaseNameBean> getSaveDiseaseName(RequestBody requestBody) {
        return getFixApid()
                .getSaveDiseaseName(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PhysicalResultsBean> getPhysicalResults(RequestBody requestBody) {
        return getFixApid()
                .getPhysicalResults(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UploadingPhysicalBean> getUploadingPhysical(RequestBody requestBody) {
        return getFixApid()
                .getUploadingPhysical(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UploadingStaminaAnswerBean> getUploadingStaminaAnswer(RequestBody requestBody) {
        return getFixApid()
                .getUploadingStaminaAnswer(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveStaminaAnswerBean> getSaveStaminaAnswer(RequestBody requestBody) {
        return getFixApid()
                .getSaveStaminaAnswer(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveStaminaResultBean> getSaveStaminaResult(RequestBody requestBody) {
        return getFixApid()
                .getSaveStaminaResult(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MakePhysicalBean> getMakePhysical(RequestBody requestBody) {
        return getFixApid()
                .getMakePhysical(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MakeAnPhysicalBean> getMakeAnPhysical(RequestBody requestBody) {
        return getFixApid()
                .getMakeAnPhysical(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SavePhysicalReportBean> getSavePhysicalReport(RequestBody requestBody) {
        return getFixApid()
                .getSavePhysicalReport(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SavePhysicalListBean> getSavePhysicalList(RequestBody requestBody) {
        return getFixApid()
                .getSavePhysicalList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveDiseaseListBean> getSaveDiseaseList(RequestBody requestBody) {
        return getFixApid()
                .getSaveDiseaseList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SaveUserSportBean> getSaveUserSport(RequestBody requestBody) {
        return getFixApid()
                .getSaveUserSport(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<HistoryPhysicalDateBean> getHistoryPhysicalDate(RequestBody requestBody) {
        return getFixApid()
                .getHistoryPhysicalDate(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SportsCenterBean> getSportsCenter(RequestBody requestBody) {
        return getFixApid()
                .getSportsCenter(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<CourseBookingBean> getCourseBooking(RequestBody requestBody) {
        return getFixApid()
                .getCourseBooking(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<EquipmentBookingBean> getEquipmentBooking(RequestBody requestBody) {
        return getFixApid()
                .getEquipmentBooking(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<VenueBookingBean> getVenueBooking(RequestBody requestBody) {
        return getFixApid()
                .getVenueBooking(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<EquipmentMakeDateBean> getEquipmentMakeDate(RequestBody requestBody) {
        return getFixApid()
                .getEquipmentMakeDate(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<VenueMakeDateBean> getVenueMakeDate(RequestBody requestBody) {
        return getFixApid()
                .getVenueMakeDate(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<HomePageBean> getHomePage(RequestBody requestBody) {
        return getFixApid()
                .getHomePage(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
