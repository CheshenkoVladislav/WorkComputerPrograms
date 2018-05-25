package com.example.vladislav.gbweatherproject.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataLoader {
    private static final String NEW_LINE = "\n";
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139";
    private static final String API_KET = "api_key";
    private static final String CITY = "Moscow";

    public static JSONObject getJsonResponse(){
        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println(connection.getResponseCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String string;
            StringBuilder inputJsonFormat = new StringBuilder(1024);
            while ((string = reader.readLine()) != null){
                inputJsonFormat.append(string).append(NEW_LINE);
            }
            reader.close();
            JSONObject json = new JSONObject(String.valueOf(inputJsonFormat));
            System.out.println(json.get("name"));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
