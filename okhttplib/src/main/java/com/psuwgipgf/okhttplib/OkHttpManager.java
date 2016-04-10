package com.psuwgipgf.okhttplib;

import com.psuwgipgf.okhttplib.request.GetRequest;
import com.psuwgipgf.okhttplib.utils.LogHelper;

import okhttp3.OkHttpClient;

/**
 * Created by psu on 2016/4/9.
 */
public class OkHttpManager {

    private static OkHttpManager mInstance;
    private volatile OkHttpClient mOkHttpClient;
    public String host;

    public static OkHttpManager getInstace() {
        if (mInstance == null) {
            synchronized (OkHttpManager.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpManager(null);
                }
            }
        }
        return mInstance;
    }

    public OkHttpManager(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            mOkHttpClient = okHttpClient;
        } else {
            //默认OkHttpClient;
            mOkHttpClient = new OkHttpClient().newBuilder().build();
        }
    }

    public OkHttpClient getOkHttpClient() {

        return mOkHttpClient;
    }


    public OkHttpManager log(String tag) {
        mOkHttpClient = getOkHttpClient().newBuilder().addInterceptor(new LogHelper(tag)).build();
        return this;
    }

    public OkHttpManager host(String url) {
        host = url;
        return this;
    }


    public static GetRequest get(){
        return new GetRequest();
    }
}
