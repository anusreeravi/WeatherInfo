package com.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.weather.app.WeatherApplication;
import com.weather.dbcontroller.DatabaseManager;
import com.weatherapp.R;

import javax.inject.Inject;

/**
 * Created by Anu on 22/02/2018.
 */

public class SplashActivity extends Activity{

    @Inject DatabaseManager dbManager;

    Runnable mShowloginScreen = new Runnable() {
        @Override
        public void run() {

           /* Intent homeIntent = new Intent(SplashActivity.this,
                    WeatherActivity.class);
            startActivity(homeIntent);
            finish();*/
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (!isTaskRoot()
                && getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
                && getIntent().getAction() != null
                && getIntent().getAction().equals(Intent.ACTION_MAIN)) {

            finish();
            return;
        }
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(mShowloginScreen,1000);
    }

}
