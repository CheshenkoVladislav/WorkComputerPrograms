package com.example.vladislav.recycleapplication.SupportClasses;

import android.app.Application;
import android.util.Log;

import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Interfaces.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vladislav on 19.03.18.
 */

public class App extends Application {
    private static final String URL = "http://verdant-violet.glitch.me/";
    public static Api api;
    public static List<Item>itemList = new ArrayList<>();
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: Holla");
        super.onCreate();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static Api getApi() {
        return api;
    }
}
