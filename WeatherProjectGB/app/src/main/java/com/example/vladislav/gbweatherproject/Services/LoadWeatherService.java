package com.example.vladislav.gbweatherproject.Services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.vladislav.gbweatherproject.DB.WeatherDataBaseConnector;
import com.example.vladislav.gbweatherproject.Data.Response;
import com.example.vladislav.gbweatherproject.Stater;
import com.example.vladislav.gbweatherproject.WeatherDataLoader;

import static android.content.ContentValues.TAG;

public class LoadWeatherService extends IntentService {
    public static String MY_INTENT_SERVICE = "myservice";

    public LoadWeatherService() {
        super("Default");
    }

    //Load from application
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (intent != null) {
                    if (intent.getStringExtra(Stater.KEY_CITY) == null) {
                        Intent intent1 = new Intent();
                        Response response = loadWeather();
                        if (response != null) {
                            String city = response.getName();
                            double temp = response.getMain().getTemp();
                            String weather = response.getWeather().get(0).getDescription();
                            String icon = response.getWeather().get(0).getIcon();
                            sendBroadcast(prepareIntent(icon, temp, weather, city));
                            sendBroadcast(intent1);
                        }
                    } else {
                        Response response = loadWeather(intent.getStringExtra(Stater.KEY_CITY));
                        if (response != null) {
                            String city = response.getName();
                            double temp = response.getMain().getTemp();
                            String weather = response.getWeather().get(0).getDescription();
                            String icon = response.getWeather().get(0).getIcon();
                            sendBroadcast(prepareIntent(icon, temp, weather, city));
                            addToDataBase(city, weather, temp, icon);
                        }
                    }
                }
                interrupt();
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private Response loadWeather() {
        return WeatherDataLoader.getJsonResponse(((Stater) getApplication()).getCity());
    }

    //Load from intent
    private Response loadWeather(String city) {
        return WeatherDataLoader.getJsonResponse(city);
    }

    private void addToDataBase(String city, String description, double temp, String icon) {
        WeatherDataBaseConnector connector = new WeatherDataBaseConnector(this);
        new Thread() {
            @Override
            public void run() {
                super.run();
                connector.open();
                connector.addWeather(city, description, temp, icon);
                connector.close();
                interrupt();
            }
        }.start();
    }

    @NonNull
    private Intent prepareIntent(String icon, double temp, String weather, String city) {
        Intent intent1 = new Intent();
        intent1.putExtra("CITY", city);
        intent1.putExtra("TEMP", temp);
        intent1.putExtra("WEATHER", weather);
        intent1.putExtra("ICON", icon);
        intent1.setAction(MY_INTENT_SERVICE);
        intent1.addCategory(Intent.CATEGORY_DEFAULT);
        return intent1;
    }
}
