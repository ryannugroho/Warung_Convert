package com.example.convertinaja;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {
    //public static final String BASE_URL = "http:/10.0.2.2:72/";
    public static final String BASE_URL = "https://ariefendi.me/fix_ta/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
