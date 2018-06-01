package com.example.vladislav.gbweatherproject;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

public class Stater extends Application {
    private static final String PREFS_NAME = "saveState";
    public static final String KEY_CITY = "city";
    private static final String KEY_CHECKBOX1 = "checkbotStatus1";
    private static final String KEY_CHECKBOX2 = "checkbotStatus2";
    private String city;

    boolean checkbox1 = false;
    boolean checkbox2 = false;
    private static final String TAG = "Stater";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        city = getSavedCity();
        initSavedCheckbox();
    }

    public void saveState() {
        if (city != null) {
            getSharedPreferences()
                    .edit()
                    .putString(KEY_CITY, new Coder().encryptState(city))
                    .putBoolean(KEY_CHECKBOX1, checkbox1)
                    .putBoolean(KEY_CHECKBOX2, checkbox2)
                    .apply();
        }
    }

    private SharedPreferences getSharedPreferences() {
        return getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    private String getSavedCity() {
        return getSharedPreferences()
                .getString(KEY_CITY, null);
    }

    void initSavedCheckbox() {
        checkbox1 = getSharedPreferences().getBoolean(KEY_CHECKBOX1, false);
        checkbox2 = getSharedPreferences().getBoolean(KEY_CHECKBOX2, false);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
