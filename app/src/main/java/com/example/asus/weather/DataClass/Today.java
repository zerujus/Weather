package com.example.asus.weather.DataClass;

/**
 * 当天天气情况
 * Created by asus on 2016/6/3.
 */
public class Today {

    //城市
    private String city;
    //日期
    private String date_y;
    //星期
    private String week;
    //今日温度
    private String temperature;
    //今日天气
    private String weather;
    //天气唯一标识
    private String weather_id;
    //风况
    private String wind;
    //穿衣指数
    private String dressing_index;
    //穿衣建议
    private String dressing_advice;
    //紫外线强度
    private String uv_index;
    //舒适度指数
    private String comfort_index;
    //洗车指数
    private String wash_index;
    //旅游指数
    private String travel_index;
    //晨练指数
    private String exercise_index;
    //干燥指数
    private String drying_index;

    public Today() {
    }

    public Today(String city, String date_y, String week, String temperature, String weather, String weather_id, String wind, String dressing_index, String dressing_advice, String uv_index, String comfort_index, String wash_index, String travel_index, String exercise_index, String drying_index) {
        this.city = city;
        this.date_y = date_y;
        this.week = week;
        this.temperature = temperature;
        this.weather = weather;
        this.weather_id = weather_id;
        this.wind = wind;
        this.dressing_index = dressing_index;
        this.dressing_advice = dressing_advice;
        this.uv_index = uv_index;
        this.comfort_index = comfort_index;
        this.wash_index = wash_index;
        this.travel_index = travel_index;
        this.exercise_index = exercise_index;
        this.drying_index = drying_index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate_y() {
        return date_y;
    }

    public void setDate_y(String date_y) {
        this.date_y = date_y;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public String getDressing_index() {
        return dressing_index;
    }

    public void setDressing_index(String dressing_index) {
        this.dressing_index = dressing_index;
    }

    public String getDressing_advice() {
        return dressing_advice;
    }

    public void setDressing_advice(String dressing_advice) {
        this.dressing_advice = dressing_advice;
    }

    public String getUv_index() {
        return uv_index;
    }

    public void setUv_index(String uv_index) {
        this.uv_index = uv_index;
    }

    public String getComfort_index() {
        return comfort_index;
    }

    public void setComfort_index(String comfort_index) {
        this.comfort_index = comfort_index;
    }

    public String getWash_index() {
        return wash_index;
    }

    public void setWash_index(String wash_index) {
        this.wash_index = wash_index;
    }

    public String getTravel_index() {
        return travel_index;
    }

    public void setTravel_index(String travel_index) {
        this.travel_index = travel_index;
    }

    public String getExercise_index() {
        return exercise_index;
    }

    public void setExercise_index(String exercise_index) {
        this.exercise_index = exercise_index;
    }

    public String getDrying_index() {
        return drying_index;
    }

    public void setDrying_index(String drying_index) {
        this.drying_index = drying_index;
    }

    @Override
    public String toString() {
        return "Today{" +
                "city='" + city + '\'' +
                ", date_y='" + date_y + '\'' +
                ", week='" + week + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", weather_id='" + weather_id + '\'' +
                ", wind='" + wind + '\'' +
                ", dressing_index='" + dressing_index + '\'' +
                ", dressing_advice='" + dressing_advice + '\'' +
                ", uv_index='" + uv_index + '\'' +
                ", comfort_index='" + comfort_index + '\'' +
                ", wash_index='" + wash_index + '\'' +
                ", travel_index='" + travel_index + '\'' +
                ", exercise_index='" + exercise_index + '\'' +
                ", drying_index='" + drying_index + '\'' +
                '}';
    }
}
