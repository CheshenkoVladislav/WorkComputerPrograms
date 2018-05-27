package com.example.vladislav.gbweatherproject.Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    @SerializedName("dt")
    private int dt;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<WeatherItem> weather;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private int cod;

    @SerializedName("main")
    private Main main;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("id")
    private int id;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("wind")
    private Wind wind;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<WeatherItem> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherItem> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "dt = '" + dt + '\'' +
                        ",rain = '" + rain + '\'' +
                        ",coord = '" + coord + '\'' +
                        ",weather = '" + weather + '\'' +
                        ",name = '" + name + '\'' +
                        ",cod = '" + cod + '\'' +
                        ",main = '" + main + '\'' +
                        ",clouds = '" + clouds + '\'' +
                        ",id = '" + id + '\'' +
                        ",sys = '" + sys + '\'' +
                        ",wind = '" + wind + '\'' +
                        "}";
    }
}