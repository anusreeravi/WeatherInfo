package com.weather.app;

import android.app.Application;

/*
  * Application class where API Key is stored and DaggerAppComponent is created
 */
public class WeatherApplication extends Application{

    public  final String API_KEY = "965faceafdc868b8e82a1abeb4648d64";
    private static WeatherApplication app = null;


    private WeatherAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        createComponent();
    }

    /*
      *Created AppComponent for module
     */
   protected void createComponent() {
       component = DaggerWeatherAppComponent.builder().weatherAppModule(new WeatherAppModule())
                            .build();
   }

    public WeatherAppComponent getComponent() {
        return component;
    }
    public void setComponent(WeatherAppComponent component) {
        this.component = component;
    }


    public static WeatherApplication getInstance() {
        return app;
    }
    public  String getApiKey() {
        return API_KEY;
    }
}
