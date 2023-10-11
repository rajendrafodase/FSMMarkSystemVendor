package com.example.fsmsystemvender.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyConfig {

    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("authtoken", "56e7957e8452621d564cdb1a")
                                .addHeader("Content-Type", "application/json")
                                .addHeader("platform", "mobile")
                                .addHeader("devicetype", "android")
                                .addHeader("usertype", "customer")
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Url.BaseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static Retrofit getRetrofitwithToken(String Token) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("authtoken", "56e7957e8452621d564cdb1a")
                                .addHeader("Content-Type", "application/json")
                                .addHeader("platform", "mobile")
                                .addHeader("devicetype", "android")
                                .addHeader("usertype", "customer")
                                .addHeader("authorization", "Bearer "+Token)
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Url.BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
