package com.example.asus.weather.Util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.asus.weather.DataClass.ByThreeHour;
import com.example.asus.weather.DataClass.City;
import com.example.asus.weather.DataClass.Sk;
import com.example.asus.weather.DataClass.Today;
import com.example.asus.weather.DataClass.Week;
import com.example.asus.weather.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 * Created by asus on 2016/6/3.
 */
public class Conversion {

    private static List<Object> list;
    private static ByThreeHour[] hours;
    private static City[] cities;

    /**
     * 根据index/ip/GPS获取天气的json
     *
     * @param context
     * @param url
     * @return 数据列表
     */
    public static List<Object> conversionToIndex(final Context context, String url) {

        //清空list
        list = null;

        Net.getInstance(context).addRequestToQueue(new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    Log.d("conversionToIndex", response);
                    JSONObject object = new JSONObject(response);
                    String resultcode = object.getString("resultcode");
                    Log.d("conversionToIndex", resultcode);
                    String reason = object.getString("reason");
                    Log.d("conversionToIndex", reason);
                    String result = object.getString("result");
                    Log.d("conversionToIndex", result);
                    String error_code = object.getString("error_code");
                    Log.d("conversionToIndex", error_code);

                    list = analysisIndexResult(result);
                } catch (JSONException e) {
                    list = null;
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "网络错误101", Toast.LENGTH_SHORT).show();
            }
        }));
        return list;
    }

    /**
     * 获取3小时间隔的天气的json
     *
     * @param context
     * @param url
     */
    public static ByThreeHour[] conversionToForecastBy3(final Context context, String url) {
        //清空
        hours = null;

        Net.getInstance(context).addRequestToQueue(new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("conversionToForecastBy3", response);
                    JSONObject object = new JSONObject(response);
                    String resultcode = object.getString("resultcode");
                    Log.d("conversionToForecastBy3", resultcode);
                    String reason = object.getString("reason");
                    Log.d("conversionToForecastBy3", reason);
                    String result = object.getString("result");
                    Log.d("conversionToForecastBy3", result);
                    String error_code = object.getString("error_code");
                    Log.d("conversionToForecastBy3", error_code);

                    hours = analysisByThreeResult(result);
                } catch (JSONException e) {
                    hours = null;
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "网络错误102", Toast.LENGTH_SHORT).show();
            }
        }));
        return hours;
    }

    /**
     * 获取城市信息
     *
     * @param context
     * @param url
     * @return City数组
     */
    public static City[] getCities(final Context context, String url) {
        //清空
        cities = null;

        Net.getInstance(context).addRequestToQueue(new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("getCities", response);
                    JSONObject object = new JSONObject(response);
                    String resultcode = object.getString("resultcode");
                    Log.d("getCities", resultcode);
                    String reason = object.getString("reason");
                    Log.d("getCities", reason);
                    String result = object.getString("result");
                    Log.d("getCities", result);
                    String error_code = object.getString("error_code");
                    Log.d("getCities", error_code);

                    cities = analysisCities(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "网络错误103", Toast.LENGTH_SHORT).show();
            }
        }));
        return cities;
    }

    /**
     * 解析json中result的数据
     *
     * @param result json数据
     * @return City[]数组
     */
    private static City[] analysisCities(String result) throws JSONException {
        JSONArray array = new JSONArray(result);
        int len = array.length();

        City[] cities = conversionToCities(array, len);
        return cities;
    }

    /**
     * 解析json中result的数据
     *
     * @param result json数据
     * @throws JSONException
     * @return ByThreeHour数组
     */
    private static ByThreeHour[] analysisByThreeResult(String result) throws JSONException {
        JSONArray array = new JSONArray(result);
        int len = array.length();

        ByThreeHour[] hours = conversionToHours(array, len);
        return hours;
    }

    /**
     * 解析json中result的数据
     *
     * @param result json数据
     */
    public static List<Object> analysisIndexResult(String result) throws JSONException {

        //sk，today，weeks放入列表
        List<Object> list = new ArrayList<>();

        JSONObject object = new JSONObject(result);

        String j_sk = object.getString("sk");
        Sk sk = conversionToSk(j_sk);
        Log.d("analysisResult", j_sk);

        String j_today = object.getString("today");
        Today today = conversionToToday(j_today);
        Log.d("analysisResult", j_today);

        String j_future = object.getString("future");
        Week[] weeks = conversionToWeek(j_future);
        Log.d("analysisResult", j_future);

        list.add(sk);
        list.add(today);
        list.add(weeks);
        return list;
    }

    /**
     * json转化为城市列表
     *
     * @param array
     * @param len
     */
    private static City[] conversionToCities(JSONArray array, int len) throws JSONException {

        City[] citiesi = new City[len];

        for (int i = 0; i < len; i++) {
            JSONObject object = array.getJSONObject(i);
            String id = object.getString("id");
            String province = object.getString("province");
            String city = object.getString("city");
            String district = object.getString("district");

            City city1 = new City(id, province, city, district);
            Log.d("conversionToCities", city1.toString());
            citiesi[i] = city1;
        }
        return citiesi;
    }


    /**
     * json转化为ByThreeHour数组
     *
     * @param array
     * @param len
     * @return ByThreeHour[]数组
     */
    private static ByThreeHour[] conversionToHours(JSONArray array, int len) throws JSONException {

        ByThreeHour[] hoursi = new ByThreeHour[len];

        for (int i = 0; i < len; i++) {
            JSONObject object = array.getJSONObject(i);
            String weatherid = object.getString("weatherid");
            String weather = object.getString("weather");
            String temp1 = object.getString("temp1");
            String temp2 = object.getString("temp2");
            String sh = object.getString("sh");
            String eh = object.getString("eh");
            String date = object.getString("date");
            String sfdate = object.getString("sfdate");
            String efdate = object.getString("efdate");

            ByThreeHour hour = new ByThreeHour(weatherid, weather, temp1, temp2, sh, eh, date, sfdate, efdate);
            Log.d("conversionToHours", hour.toString());
            hoursi[i] = hour;
        }
        return hoursi;
    }

    /**
     * json转化为Week数组
     *
     * @param j_future
     * @return Week[]数组
     */
    private static Week[] conversionToWeek(String j_future) throws JSONException {

        Week[] weeks = new Week[7];

        JSONArray array = new JSONArray(j_future);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            String temperature = object.getString("temperature");
            String weather = object.getString("weather");
            String weather_id = object.getString("weather_id");
            String wind = object.getString("wind");
            String week = object.getString("week");
            String date = object.getString("date");

            Week weeki = new Week(temperature, weather, weather_id, wind, week, date);
            Log.d("conversionToWeek", weeki.toString());
            weeks[i] = weeki;
        }
        return weeks;
    }

    /**
     * json转化为Today对象
     *
     * @param j_today
     * @return Today对象
     */
    private static Today conversionToToday(String j_today) throws JSONException {

        JSONObject object = new JSONObject(j_today);
        String city = object.getString("city");
        String date_y = object.getString("date_y");
        String week = object.getString("week");
        String temperature = object.getString("temperature");
        String weather = object.getString("weather");
        String weather_id = object.getString("weather_id");
        String wind = object.getString("wind");
        String dressing_index = object.getString("dressing_index");
        String dressing_advice = object.getString("dressing_advice");
        String uv_index = object.getString("uv_index");
        String comfort_index = object.getString("comfort_index");
        String wash_index = object.getString("wash_index");
        String travel_index = object.getString("travel_index");
        String exercise_index = object.getString("exercise_index");
        String drying_index = object.getString("drying_index");

        Today today = new Today(city, date_y, week, temperature, weather, weather_id, wind, dressing_index, dressing_advice, uv_index, comfort_index, wash_index, travel_index, exercise_index, drying_index);
        Log.d("conversionToToday", today.toString());
        return today;
    }

    /**
     * json转化为Sk对象
     *
     * @param j_sk
     * @return Sk对象
     */
    private static Sk conversionToSk(String j_sk) throws JSONException {

        JSONObject object = new JSONObject(j_sk);
        String temp = object.getString("temp");
        String wind_direction = object.getString("wind_direction");
        String wind_strength = object.getString("wind_strength");
        String humidity = object.getString("humidity");
        String time = object.getString("time");

        Sk sk = new Sk(temp, wind_direction, wind_strength, humidity, time);
        Log.d("converSionToSk", sk.toString());
        return sk;
    }

    /**
     * Index中的图标选择
     *
     * @param weather_id
     * @return
     * @throws JSONException
     */
    private static int[] disposeIndexWeatherId(String weather_id) throws JSONException {
        int i = 0, j = 0;

        JSONObject object = new JSONObject(weather_id);
        String fa = object.getString("fa");
        String fb = object.getString("fb");
        switch (fa) {
            case "00":
                i = R.drawable.d00;
                break;
            case "01":
                i = R.drawable.d01;
                break;
            case "02":
                i = R.drawable.d02;
                break;
            case "03":
                i = R.drawable.d03;
                break;
            case "04":
                i = R.drawable.d04;
                break;
            case "05":
                i = R.drawable.d05;
                break;
            case "06":
                i = R.drawable.d06;
                break;
            case "07":
                i = R.drawable.d07;
                break;
            case "08":
                i = R.drawable.d08;
                break;
            case "09":
                i = R.drawable.d03;
                break;
            case "10":
                i = R.drawable.d10;
                break;
            case "11":
                i = R.drawable.d11;
                break;
            case "12":
                i = R.drawable.d12;
                break;
            case "13":
                i = R.drawable.d13;
                break;
            case "14":
                i = R.drawable.d14;
                break;
            case "15":
                i = R.drawable.d15;
                break;
            case "16":
                i = R.drawable.d16;
                break;
            case "17":
                i = R.drawable.d17;
                break;
            case "18":
                i = R.drawable.d18;
                break;
            case "19":
                i = R.drawable.d19;
                break;
            case "20":
                i = R.drawable.d20;
                break;
            case "21":
                i = R.drawable.d21;
                break;
            case "22":
                i = R.drawable.d22;
                break;
            case "23":
                i = R.drawable.d23;
                break;
            case "24":
                i = R.drawable.d24;
                break;
            case "25":
                i = R.drawable.d25;
                break;
            case "26":
                i = R.drawable.d26;
                break;
            case "27":
                i = R.drawable.d27;
                break;
            case "28":
                i = R.drawable.d28;
                break;
            case "29":
                i = R.drawable.d29;
                break;
            case "30":
                i = R.drawable.d30;
                break;
            case "31":
                i = R.drawable.d31;
                break;
            case "53":
                i = R.drawable.d53;
                break;
        }
        switch (fb) {
            case "00":
                j = R.drawable.d00;
                break;
            case "01":
                j = R.drawable.d01;
                break;
            case "02":
                j = R.drawable.d02;
                break;
            case "03":
                j = R.drawable.d03;
                break;
            case "04":
                j = R.drawable.d04;
                break;
            case "05":
                j = R.drawable.d05;
                break;
            case "06":
                j = R.drawable.d06;
                break;
            case "07":
                j = R.drawable.d07;
                break;
            case "08":
                j = R.drawable.d08;
                break;
            case "09":
                j = R.drawable.d03;
                break;
            case "10":
                j = R.drawable.d10;
                break;
            case "11":
                j = R.drawable.d11;
                break;
            case "12":
                j = R.drawable.d12;
                break;
            case "13":
                j = R.drawable.d13;
                break;
            case "14":
                j = R.drawable.d14;
                break;
            case "15":
                j = R.drawable.d15;
                break;
            case "16":
                j = R.drawable.d16;
                break;
            case "17":
                j = R.drawable.d17;
                break;
            case "18":
                j = R.drawable.d18;
                break;
            case "19":
                j = R.drawable.d19;
                break;
            case "20":
                j = R.drawable.d20;
                break;
            case "21":
                j = R.drawable.d21;
                break;
            case "22":
                j = R.drawable.d22;
                break;
            case "23":
                j = R.drawable.d23;
                break;
            case "24":
                j = R.drawable.d24;
                break;
            case "25":
                j = R.drawable.d25;
                break;
            case "26":
                j = R.drawable.d26;
                break;
            case "27":
                j = R.drawable.d27;
                break;
            case "28":
                j = R.drawable.d28;
                break;
            case "29":
                j = R.drawable.d29;
                break;
            case "30":
                j = R.drawable.d30;
                break;
            case "31":
                j = R.drawable.d31;
                break;
            case "53":
                j = R.drawable.d53;
                break;
        }
        int[] drawable = {i, j};
        return drawable;
    }

    /**
     * Forecastby3的图标选择
     *
     * @param sfdate
     * @param weather_id
     */
    private static int disposeForecast3hWeatherId(String sfdate, String weather_id) {
        int i = 0;
        String time = sfdate.substring(8, 10);
        Log.d("disposeForecast3", time);
        int t = Integer.parseInt(time);
        if (t <= 17 && t >= 5) {
            switch (weather_id) {
                case "00":
                    i = R.drawable.d00;
                    break;
                case "01":
                    i = R.drawable.d01;
                    break;
                case "02":
                    i = R.drawable.d02;
                    break;
                case "03":
                    i = R.drawable.d03;
                    break;
                case "04":
                    i = R.drawable.d04;
                    break;
                case "05":
                    i = R.drawable.d05;
                    break;
                case "06":
                    i = R.drawable.d06;
                    break;
                case "07":
                    i = R.drawable.d07;
                    break;
                case "08":
                    i = R.drawable.d08;
                    break;
                case "09":
                    i = R.drawable.d03;
                    break;
                case "10":
                    i = R.drawable.d10;
                    break;
                case "11":
                    i = R.drawable.d11;
                    break;
                case "12":
                    i = R.drawable.d12;
                    break;
                case "13":
                    i = R.drawable.d13;
                    break;
                case "14":
                    i = R.drawable.d14;
                    break;
                case "15":
                    i = R.drawable.d15;
                    break;
                case "16":
                    i = R.drawable.d16;
                    break;
                case "17":
                    i = R.drawable.d17;
                    break;
                case "18":
                    i = R.drawable.d18;
                    break;
                case "19":
                    i = R.drawable.d19;
                    break;
                case "20":
                    i = R.drawable.d20;
                    break;
                case "21":
                    i = R.drawable.d21;
                    break;
                case "22":
                    i = R.drawable.d22;
                    break;
                case "23":
                    i = R.drawable.d23;
                    break;
                case "24":
                    i = R.drawable.d24;
                    break;
                case "25":
                    i = R.drawable.d25;
                    break;
                case "26":
                    i = R.drawable.d26;
                    break;
                case "27":
                    i = R.drawable.d27;
                    break;
                case "28":
                    i = R.drawable.d28;
                    break;
                case "29":
                    i = R.drawable.d29;
                    break;
                case "30":
                    i = R.drawable.d30;
                    break;
                case "31":
                    i = R.drawable.d31;
                    break;
                case "53":
                    i = R.drawable.d53;
                    break;
            }
        } else {
            switch (weather_id) {
                case "00":
                    i = R.drawable.n00;
                    break;
                case "01":
                    i = R.drawable.n01;
                    break;
                case "02":
                    i = R.drawable.n02;
                    break;
                case "03":
                    i = R.drawable.n03;
                    break;
                case "04":
                    i = R.drawable.n04;
                    break;
                case "05":
                    i = R.drawable.n05;
                    break;
                case "06":
                    i = R.drawable.n06;
                    break;
                case "07":
                    i = R.drawable.n07;
                    break;
                case "08":
                    i = R.drawable.n08;
                    break;
                case "09":
                    i = R.drawable.n03;
                    break;
                case "10":
                    i = R.drawable.n10;
                    break;
                case "11":
                    i = R.drawable.n11;
                    break;
                case "12":
                    i = R.drawable.n12;
                    break;
                case "13":
                    i = R.drawable.n13;
                    break;
                case "14":
                    i = R.drawable.n14;
                    break;
                case "15":
                    i = R.drawable.n15;
                    break;
                case "16":
                    i = R.drawable.n16;
                    break;
                case "17":
                    i = R.drawable.n17;
                    break;
                case "18":
                    i = R.drawable.n18;
                    break;
                case "19":
                    i = R.drawable.n19;
                    break;
                case "20":
                    i = R.drawable.n20;
                    break;
                case "21":
                    i = R.drawable.n21;
                    break;
                case "22":
                    i = R.drawable.n22;
                    break;
                case "23":
                    i = R.drawable.n23;
                    break;
                case "24":
                    i = R.drawable.n24;
                    break;
                case "25":
                    i = R.drawable.n25;
                    break;
                case "26":
                    i = R.drawable.n26;
                    break;
                case "27":
                    i = R.drawable.n27;
                    break;
                case "28":
                    i = R.drawable.n28;
                    break;
                case "29":
                    i = R.drawable.n29;
                    break;
                case "30":
                    i = R.drawable.n30;
                    break;
                case "31":
                    i = R.drawable.n31;
                    break;
                case "53":
                    i = R.drawable.n53;
                    break;
            }
        }
        return i;
    }
}
