package com.example.asus.weather.Activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.asus.weather.DataClass.City;
import com.example.asus.weather.DataClass.Sk;
import com.example.asus.weather.DataClass.Today;
import com.example.asus.weather.DataClass.Week;
import com.example.asus.weather.R;
import com.example.asus.weather.Util.Conversion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup group;
    private RadioButton radioButton_GPS;
    private RadioButton radioButton_Index;
    private Spinner spinner_province;
    private Spinner spinner_city;
    private Spinner spinner_district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDialog();

    }

    /**
     * 初始化对话框
     */
    private void initDialog() {

        City[] cities = Conversion.getCities(this, "http://v.juhe.cn/weather/citys?key=ba5c4ae1351a5933ecdaeef2777e7b19");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(getLayoutInflater().inflate(R.layout.dialog_customtitle, null));

        View view = getLayoutInflater().inflate(R.layout.dialog_context, null);
        builder.setView(view);

        //findViewById
        group = (RadioGroup) view.findViewById(R.id.group);
        radioButton_GPS = (RadioButton) view.findViewById(R.id.radioButton_GPS);
        radioButton_Index = (RadioButton) view.findViewById(R.id.radioButton_Index);
        spinner_province = (Spinner) view.findViewById(R.id.spinner_province);
        spinner_city = (Spinner) view.findViewById(R.id.spinner_city);
        spinner_district = (Spinner) view.findViewById(R.id.spinner_district);

        //默认自动定位选中
        radioButton_GPS.setChecked(true);

        //初始化spinner
        ArrayAdapter<City> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
        spinner_province.setAdapter(adapter);

        //为dialog中的控件添加事件
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //手动定位选中时，spinner可选
                if (checkedId == R.id.radioButton_GPS) {
                    spinner_province.setEnabled(false);
                    spinner_city.setEnabled(false);
                    spinner_district.setEnabled(false);
                } else if (checkedId == R.id.radioButton_Index) {
                    spinner_province.setEnabled(true);
                    spinner_city.setEnabled(true);
                    spinner_district.setEnabled(true);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 对话框确定
     * @param v
     */
    public void getMessage(View v){

    }

    /**
     * 对话框取消
     * @param v
     */
    public void cancel(View v){

    }
}
