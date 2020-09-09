package com.example.gadsleaderboard.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient2 {

    public  static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    public  static Retrofit retrofit = null;


    public static  Retrofit getApiClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
