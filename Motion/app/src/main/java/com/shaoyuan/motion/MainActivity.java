package com.shaoyuan.motion;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shaoyuan.core.netcheck.NetworkChangeListener;

public class MainActivity extends AppCompatActivity {

    NetworkChangeListener networkChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //在onResume()方法注册
    @Override
    protected void onResume() {
        if (networkChangeListener == null) {
            networkChangeListener = new NetworkChangeListener();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        System.out.println("注册");
        super.onResume();
    }

    //onPause()方法注销
    @Override
    protected void onPause() {
        unregisterReceiver(networkChangeListener);
        System.out.println("注销");
        super.onPause();
    }
}
