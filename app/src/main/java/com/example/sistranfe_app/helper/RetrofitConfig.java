package com.example.sistranfe_app.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl( NfeConfig.URL_BASE )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofitPull(){
        return new Retrofit.Builder()
                .baseUrl( NfeConfig.URL_BASE_PULL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
