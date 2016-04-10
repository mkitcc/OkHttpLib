package com.psuwgipgf.okhttplib.request;

import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by psu on 2016/4/10.
 */
public class GetRequest extends OkHttpRequest {


    @Override
    public GetRequest host(String u) {
        host = u;
        return this;
    }

    @Override
    public GetRequest url(String u) {
        url = u;
        return this;
    }

    @Override
    public GetRequest tag(String u) {
        tag = u;
        return this;
    }

    @Override
    public GetRequest addHeader(String k, String v) {
        if (mHeader == null) {
            mHeader = new LinkedHashMap<>();
        }
        mHeader.put(k, v);
        return this;
    }

    @Override
    public GetRequest setHeader(Map<String, String> p) {
        mHeader = p;
        return this;
    }

    @Override
    public GetRequest addParams(String k, String v) {
        if (mParams == null) {
            mParams = new LinkedHashMap<>();
        }
        mParams.put(k, v);
        return this;
    }

    @Override
    public OkHttpRequest setParams(Map<String, String> p) {
        mParams = p;
        return null;
    }

    @Override
    public void build() {
        request = new Request.Builder()
                .url(host + url)
                .tag(tag)
                .get()
                .build();
    }


}
