package com.example.geniusplazechallenge.networking;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://reqres.in/api/";

    public static Retrofit getRetrofit() {
        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client=new OkHttpClient().newBuilder().connectTimeout(500, TimeUnit.MILLISECONDS)
                    .readTimeout(500,TimeUnit.MILLISECONDS).addInterceptor(logging).build();
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }

}
