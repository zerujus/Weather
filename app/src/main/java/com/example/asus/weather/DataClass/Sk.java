package com.example.asus.weather.DataClass;

/**
 * 当前实况天气
 * Created by asus on 2016/6/3.
 */
public class Sk {

    //当前温度
    private String temp;
    //当前风向
    private String wind_direction;
    //当前风力
    private String wind_strength;
    //当前湿度
    private String humidity;
    //更新时间
    private String time;

    public Sk() {
    }

    public Sk(String temp, String wind_direction, String wind_strength, String humidity, String time) {
        this.temp = temp;
        this.wind_direction = wind_direction;
        this.wind_strength = wind_strength;
        this.humidity = humidity;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_strength() {
        return wind_strength;
    }

    public void setWind_strength(String wind_strengh) {
        this.wind_strength = wind_strength;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Sk{" +
                "temp='" + temp + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", wind_strengh='" + wind_strength + '\'' +
                ", humidity='" + humidity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
