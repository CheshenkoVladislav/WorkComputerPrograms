package com.example.vladislav.gbweatherproject.Data;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private double temp;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("temp_max")
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public String toString() {
        return
                "Main{" +
                        "temp = '" + temp + '\'' +
                        ",temp_min = '" + tempMin + '\'' +
                        ",humidity = '" + humidity + '\'' +
                        ",pressure = '" + pressure + '\'' +
                        ",temp_max = '" + tempMax + '\'' +
                        "}";
    }
}