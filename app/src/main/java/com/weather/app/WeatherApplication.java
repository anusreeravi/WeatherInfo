package com.weather.app;

import android.app.Application;

/**
 * Created by Anu on 22/02/2018.
 */

public class WeatherApplication extends Application{

    public  final String API_KEY = "965faceafdc868b8e82a1abeb4648d64";
    private static WeatherApplication app = null;



    public static WeatherApplication getInstance() {
        return app;
    }
    public  String getApiKey() {
        return API_KEY;
    }
}
