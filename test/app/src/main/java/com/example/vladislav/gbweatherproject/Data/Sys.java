package com.example.vladislav.gbweatherproject.Data;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private double sunrise;

    @SerializedName("sunset")
    private double sunset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return
                "Sys{" +
                        "country = '" + country + '\'' +
                        ",sunrise = '" + sunrise + '\'' +
                        ",sunset = '" + sunset + '\'' +
                        "}";
    }
}