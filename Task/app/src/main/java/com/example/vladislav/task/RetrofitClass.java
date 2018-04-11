package com.example.vladislav.task;

import android.app.Application;
import android.util.Log;

import com.example.vladislav.task.Interfaces.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass extends Application {
    private static final String TAG = "RetrofitClass";
    private String URL = BuildConfig.BASE_URL;
    private String URL2 = "https://producthunt.com/";
    private String TOKEN_KEY = "login";
    private String TOKEN = "591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff";
    HttpLoggingInterceptor inter;
    OkHttpClient.Builder httpClient;
    public static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        httpClient = new OkHttpClient.Builder();
        inter = new HttpLoggingInterceptor();
        inter.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(inter);
        Gson gsonConverter = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL2)
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .client(httpClient.build())
                .build();
        api = retrofit.create(Api.class);
        Log.d(TAG, "onCreate: API retroit: " + api);
    }

    public static Api getApi() {return api;}

    public String getTOKEN() {return TOKEN;}
}
