package com.example.fsmsystemvender.NetworkController;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyConfig
{
        public static final String JSON_BASE_URL = "https://marg.routemate.in/";
        public static final String JSON_DECRYPTION_URL = "https://thescrapwale.com/api/";
    public static final String JSON_Sub_URL = "api/v1/eOnlineData/";
    public static final String DemoKEY = "5Z6HWPTG3O4K";

    public static Retrofit retrofit=null;
        public static Retrofit getRetrofit() {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(JSON_BASE_URL)
                    .client(new OkHttpClient.Builder().
                            connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .writeTimeout(60,TimeUnit.SECONDS)
                            .build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            return retrofit;
    }



    public static Retrofit retrofit2=null;
    public static Retrofit getDecryptionRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit2 = new Retrofit.Builder()
                .baseUrl(JSON_DECRYPTION_URL)
                .client(new OkHttpClient.Builder().
                        connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60,TimeUnit.SECONDS)
                        .build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit2;
    }

}
