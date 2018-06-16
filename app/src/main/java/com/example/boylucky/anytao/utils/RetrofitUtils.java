package com.example.boylucky.anytao.utils;

import com.example.boylucky.anytao.api.MainAPi;
import com.example.boylucky.anytao.common.Contanx;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BoyLucky on 2018/6/12.
 */

public class RetrofitUtils {
    public static MainAPi mainAPi;
    public static RetrofitUtils retrofitUtils;
    public RetrofitUtils() {
        OkHttpClient builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contanx.URL)
                .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder)
                .build();
    mainAPi = retrofit.create(MainAPi.class);
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils == null){
            retrofitUtils = new RetrofitUtils();
        }
        return retrofitUtils;
    }
    public MainAPi api(){
        return mainAPi;
    }
}
