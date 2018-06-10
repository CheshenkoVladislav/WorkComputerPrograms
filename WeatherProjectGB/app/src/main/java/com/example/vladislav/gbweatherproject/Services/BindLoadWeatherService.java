package com.example.vladislav.gbweatherproject.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class BindLoadWeatherService extends Service{
    MyBinder binder = new MyBinder();
    Timer timer;
    TimerTask ttask;
    private int pause = 10000;
    private static final String TAG = "BindLoadWeatherService";

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        if (ttask != null)ttask.cancel();
        ttask = new TimerTask() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + pause);
            }
        };
        timer.schedule(ttask,1000,pause);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        ttask.cancel();
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public class MyBinder extends Binder{
        public BindLoadWeatherService getService(){
            return BindLoadWeatherService.this;
        }
    }
}
