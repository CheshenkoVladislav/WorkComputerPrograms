package com.example.vladislav.gbweatherproject;

import com.example.vladislav.gbweatherproject.Data.Response;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataLoader {
    private static final String NEW_LINE = "\n";
    private static final String APP_ID = "c3d1f877f859b2dd7549f5754e452338";
    private static final String URL = "http://api.openweathermap.org/data/2.5/" +
            "weather?q=%s" +
            "&units=metric" +
            "&appid=%s";
    public static Response getJsonResponse(String city) {
        try {
            URL url = new URL(String.format(URL, city.toUpperCase(), APP_ID));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println(connection.getResponseCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String string;
            StringBuilder inputJsonFormat = new StringBuilder(1024);
            while ((string = reader.readLine()) != null) {
                inputJsonFormat.append(string).append(NEW_LINE);
            }
            reader.close();
            Gson gson = new Gson();
            System.out.println(inputJsonFormat);
            Response response = gson.fromJson(inputJsonFormat.toString(), Response.class);
            System.out.println(response.getCod());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
