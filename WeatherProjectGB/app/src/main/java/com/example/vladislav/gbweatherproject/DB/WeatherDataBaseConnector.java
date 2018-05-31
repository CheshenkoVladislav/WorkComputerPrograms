package com.example.vladislav.gbweatherproject.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class WeatherDataBaseConnector {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private static final String cityColumn = DataBaseHelper.COLUMN_CITY;
    private static final String descriptionColumn = DataBaseHelper.COLUMN_WEATHER_DESCRIPTION;
    private static final String tempColumn = DataBaseHelper.COLUMN_TEMPERATURE;

    public WeatherDataBaseConnector(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void open(){
        database = dataBaseHelper.getWritableDatabase();
    }

    public void addWeather(String city,String description,double temp) {
        ContentValues value = new ContentValues();
        value.put(cityColumn, city);
        value.put(descriptionColumn, description);
        value.put(tempColumn, temp);
        database.insert(DataBaseHelper.TABLE_WEATHER,null,value);
    }
}
