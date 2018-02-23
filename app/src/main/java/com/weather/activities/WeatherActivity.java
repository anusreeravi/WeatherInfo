package com.weather.activities;

/**
 * Created by Anu on 22/02/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.weather.R;
import com.weather.app.WeatherApplication;
import com.weather.weatherdetails.WeatherListFragment;

/*
  Activity class showing weather details
 */
public class WeatherActivity extends AppCompatActivity {

    /*
       Added Weather details Fragment for displaying data to screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        WeatherListFragment weatherDetailsFragment = new WeatherListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, weatherDetailsFragment).disallowAddToBackStack().commit();
    }

}
