package com.example.asus.weather.DataClass;

/**
 * 城市信息
 * Created by asus on 2016/6/3.
 */
public class City {

    //城市ID
    private String id;
    //省份名称
    private String province;
    //城市
    private String city;
    //城市/区名称
    private String district;

    public City(String id, String province, String city, String district) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public City() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
