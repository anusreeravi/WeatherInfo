package com.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.weather.R;

/*
  Activity Class for Initial Screen
 */
public class SplashActivity extends Activity{

    /*
       Loading Weather Details Page
     */
    Runnable mShowloginScreen = new Runnable() {
        @Override
        public void run() {

            Intent homeIntent = new Intent(SplashActivity.this,
                    WeatherActivity.class);
            startActivity(homeIntent);
            finish();
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
