package com.example.asus.weather.DataClass;

/**
 * by三小时天气情况
 * Created by asus on 2016/6/3.
 */
public class ByThreeHour {
    //天气ID标识
    private String weatherid;
    //天气
    private String weather;
    //低温
    private String temp1;
    //高温
    private String temp2;
    //开始小时
    private String sh;
    //结束小时
    private String eh;
    //日期
    private String date;
    //完整开始时间
    private String sfdate;
    //完整结束时间
    private String efdate;

    public ByThreeHour() {
    }

    public ByThreeHour(String weatherid, String weather, String temp1, String temp2, String sh, String eh, String date, String sfdate, String efdate) {
        this.weatherid = weatherid;
        this.weather = weather;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.sh = sh;
        this.eh = eh;
        this.date = date;
        this.sfdate = sfdate;
        this.efdate = efdate;
    }

    public String getWeatherid() {
        return weatherid;
    }

    public void setWeatherid(String weatherid) {
        this.weatherid = weatherid;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getEh() {
        return eh;
    }

    public void setEh(String eh) {
        this.eh = eh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSfdate() {
        return sfdate;
    }

    public void setSfdate(String sfdate) {
        this.sfdate = sfdate;
    }

    public String getEfdate() {
        return efdate;
    }

    public void setEfdate(String efdate) {
        this.efdate = efdate;
    }

    @Override
    public String toString() {
        return "ByThreeHour{" +
                "weatherid='" + weatherid + '\'' +
                ", weather='" + weather + '\'' +
                ", temp1='" + temp1 + '\'' +
                ", temp2='" + temp2 + '\'' +
                ", sh='" + sh + '\'' +
                ", eh='" + eh + '\'' +
                ", date='" + date + '\'' +
                ", sfdate='" + sfdate + '\'' +
                ", efdate='" + efdate + '\'' +
                '}';
    }
}
