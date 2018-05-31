package com.example.vladislav.gbweatherproject.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "weather_list";
    private static final int DB_VERSION = 1;
    public static final String TABLE_WEATHER = "weather2";

    private static final String COLUMN_ID = "_id";
    static final String COLUMN_CITY = "city";
    static final String COLUMN_WEATHER_DESCRIPTION = "description";
    static final String COLUMN_TEMPERATURE = "temperature";
    static final String COLUMN_ICON = "icon";

    DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createExec = "CREATE TABLE " + TABLE_WEATHER
                + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CITY + " TEXT NOT NULL," +
                COLUMN_WEATHER_DESCRIPTION + " TEXT NOT NULL," +
                COLUMN_TEMPERATURE + " REAL NOT NULL," +
                COLUMN_ICON + " TEXT);";
        db.execSQL(createExec);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
