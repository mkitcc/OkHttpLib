package com.libvirus.test;

import android.app.Application;

import com.libvirus.okhttplib.OkHttpManager;

/**
 * Created by psu on 2016/4/10.
 */
public class AppContext extends Application {


    String host="http://192.168.0.107:5000";

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpManager.getInstace().host(host).log("psuwgipgf");
    }
}
