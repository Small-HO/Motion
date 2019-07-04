package com.shaoyuan.motion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shaoyuan.aspectj.Interface.LoginIntercept;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ceshi();
    }

    @LoginIntercept
    private void ceshi() {

    }


}
