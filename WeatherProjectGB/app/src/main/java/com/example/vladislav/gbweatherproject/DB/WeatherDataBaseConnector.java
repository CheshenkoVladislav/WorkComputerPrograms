package com.example.vladislav.gbweatherproject.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

public class WeatherDataBaseConnector {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private static final String[] columnsForCursor = {
            DataBaseHelper.COLUMN_CITY,
            DataBaseHelper.COLUMN_WEATHER_DESCRIPTION,
            DataBaseHelper.COLUMN_TEMPERATURE,
            DataBaseHelper.COLUMN_ICON
    };

    public WeatherDataBaseConnector(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void open() {
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
        dataBaseHelper.close();
    }

    public void addWeather(String city, String description, double temp, String icon) {
        database.replace(DataBaseHelper.TABLE_WEATHER, null,
                getContentValue(city, description, temp, icon));
    }

    @NonNull
    private ContentValues getContentValue(String city, String description, double temp, String icon) {
        ContentValues value = new ContentValues();
        value.put(DataBaseHelper.COLUMN_CITY, city);
        value.put(DataBaseHelper.COLUMN_WEATHER_DESCRIPTION, description);
        value.put(DataBaseHelper.COLUMN_TEMPERATURE, temp);
        value.put(DataBaseHelper.COLUMN_ICON, icon);
        return value;
    }
}
