package com.it.hungvt.moviesapp.data.source.remote.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.it.hungvt.moviesapp.utils.Constant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 11/20/2017.
 */

public class ServiceClient {

    static <T> T createService(String endPointUrl, Class<T> serviceClass){

        Gson gson = new GsonBuilder().setDateFormat(Constant.FORMAT_DATE).create();

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(Constant.END_POINT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(serviceClass);
    }

}
