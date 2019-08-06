package com.shaoyuan.motion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.shaoyuan.api.Constants;
import com.shaoyuan.motion.ui.fragment.DataFragment;
import com.shaoyuan.motion.ui.fragment.HomeFragment;
import com.shaoyuan.motion.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    private final Long interval = 4L;//定位时间间隔(注：高德地图初始定位北京，设置为0直接定位当前位置，增加用户体验)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(savedInstanceState);
        showContacts();
        getLocation();
    }

    private void addFragment(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (savedInstanceState == null) {
            fragments.add(new HomeFragment());
            fragments.add(new DataFragment());
            fragments.add(new MineFragment());

            int index = 0;
            for (Fragment f :fragments) {
                transaction.add(R.id.fragment,f,"tag" + index);
                transaction.hide(f);
                index ++;
            }
            transaction.show(fragments.get(0));
            transaction.commit();
        }else {
            for (int i = 0; i < fragments.size(); i++) {
                String tag = "tag" + i;
                Fragment f = manager.findFragmentByTag(tag);
                if (f != null) {
                    fragments.add(f);
                }
            }
        }
    }

    @OnClick({R.id.tb_tb_home,R.id.tb_tv_data,R.id.tb_tv_mine})
    public void onClick(View view) {
        int index = 0;
        switch (view.getId()) {
            case R.id.tb_tb_home:
                index = 0;
                break;
            case R.id.tb_tv_data:
                index = 1;
                break;
            case R.id.tb_tv_mine:
                index = 2;
                break;
        }
        switchFragment(index);
    }

    private void switchFragment(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (index >= 0 && index < fragments.size()) {
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                if (i == index){
                    transaction.show(fragment);
                }else {
                    transaction.hide(fragment);
                }
            }
            transaction.commit();
        }
    }

    @Override
    protected int getLayoutId() {
        setTheme(R.style.AppTheme);
        return R.layout.activity_main;
    }

    //高德定位
    private void getLocation(){
        mLocationClient = new AMapLocationClient(this);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mLocationOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mLocationOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mLocationOption.setInterval(interval);//可选，设置定位间隔。默认为2秒
        mLocationOption.setNeedAddress(false);//可选，设置是否返回逆地理地址信息。默认是true
        mLocationOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mLocationOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mLocationOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mLocationOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mLocationOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        mLocationOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.ZH);//可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
        mLocationClient.setLocationOption(mLocationOption);
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //开始定位
        mLocationClient.startLocation();
    }

    //声明定位回调监听器
    public AMapLocationListener mLocationListener = aMapLocation -> {
        //Log.e("TAG","纬度信息为" + aMapLocation.getLatitude() + "\n经度信息为" + aMapLocation.getLongitude());
        Constants.JINDDU=aMapLocation.getLongitude();
        Constants.WEIDU=aMapLocation.getLatitude();
    };


    public void showContacts() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "没有权限,请手动开启定位权限", Toast.LENGTH_SHORT).show();
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, 100);
        }
    }
}
