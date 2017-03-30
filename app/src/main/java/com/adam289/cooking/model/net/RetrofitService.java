package com.adam289.cooking.model.net;

import com.adam289.cooking.BuildConfig;
import com.adam289.cooking.utils.MyContants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class RetrofitService {
    private static RetrofitService instance = null;
    public static RetrofitService getInstance(){
        if(instance==null){
            instance = new RetrofitService();
        }
        return  instance;
    }
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private RetrofitService(){
        if(BuildConfig.DEBUG){
            okHttpClient  = new OkHttpClient();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            retrofit = new Retrofit.Builder().baseUrl(MyContants.baseURL).addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient).build();
        }else{
            okHttpClient = new OkHttpClient();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            retrofit = new Retrofit.Builder().baseUrl(MyContants.baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient).build();
        }
    }
    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
