package com.example.asus.weather.DataClass;

/**
 * 未来6天天气
 * Created by asus on 2016/6/3.
 */
public class Week {

    //温度
    private String temperature;
    //天气
    private String weather;
    //天气唯一标识
    private String weather_id;
    //风况
    private String wind;
    //星期
    private String week;
    //日期
    private String date;

    public Week() {
    }

    public Week(String temperature, String weather, String weather_id, String wind, String week, String date) {
        this.temperature = temperature;
        this.weather = weather;
        this.weather_id = weather_id;
        this.wind = wind;
        this.week = week;
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Week{" +
                "temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", weather_id='" + weather_id + '\'' +
                ", wind='" + wind + '\'' +
                ", week='" + week + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
