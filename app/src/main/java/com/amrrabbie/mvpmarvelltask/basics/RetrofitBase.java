package com.amrrabbie.mvpmarvelltask.basics;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBase {



    public static Retrofit defineRetrofit(){

        String url= BasicUrl.ApiUrl;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        return  retrofit;

    }
}
