package com.example.vladislav.task;

import android.app.Application;
import android.util.Log;

import com.example.vladislav.task.Interfaces.Api;

import retrofit2.Retrofit;

public class RetrofitClass extends Application {
    private static final String TAG = "RetrofitClass";
    private String URL = BuildConfig.BASE_URL;
    private String URL2= "https://api.producthunt.com/";

    public static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .build();
        api = retrofit.create(Api.class);
        Log.d(TAG, "onCreate: API retroit: " + api);
    }

    public static Api getApi() {return api;}
}
