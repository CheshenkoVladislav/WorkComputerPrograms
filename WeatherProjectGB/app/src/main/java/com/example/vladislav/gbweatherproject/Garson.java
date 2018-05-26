package com.example.vladislav.gbweatherproject;

import com.example.vladislav.gbweatherproject.Data.Response;
import com.google.gson.Gson;
import com.example.vladislav.gbweatherproject.Data.Response;
import com.example.vladislav.gbweatherproject.Data.Sys;
import com.example.vladislav.gbweatherproject.Data.WeatherItem;
import com.google.gson.Gson;
public class Garson {
        private static String v = "{\"coord\":{\"lon\":139,\"lat\":35},\n" +
                "\"sys\":{\"country\":\"JP\",\"sunrise\":1369769524,\"sunset\":1369821049},\n" +
                "\"weather\":[{\"id\":804,\"main\":\"clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\n" +
                "\"main\":{\"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04},\n" +
                "\"wind\":{\"speed\":7.31,\"deg\":187.002},\n" +
                "\"rain\":{\"3h\":0},\n" +
                "\"clouds\":{\"all\":92},\n" +
                "\"dt\":1369824698,\n" +
                "\"id\":1851632,\n" +
                "\"name\":\"Shuzenji\",\n" +
                "\"cod\":200}";
        public static void main(String[] args) {
            Gson gson = new Gson();
            Response response = gson.fromJson(v, Response.class);
            System.out.println(response.getMain().getTemp());
        }
    }
