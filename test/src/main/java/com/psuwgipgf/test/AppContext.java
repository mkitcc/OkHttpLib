package com.psuwgipgf.test;

import android.app.Application;

import com.psuwgipgf.okhttplib.OkHttpManager;

/**
 * Created by psu on 2016/4/10.
 */
public class AppContext extends Application {


    String host="http://192.168.0.102:5000";

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpManager.getInstace().host(host).log("psuwgipgf");
    }
}
