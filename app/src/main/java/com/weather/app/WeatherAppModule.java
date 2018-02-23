package com.weather.app;

/**
 * Created by Anu on 22/02/2018.
 */

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public  class WeatherAppModule {

    @Provides
    @Singleton
    public Context provideContext(){
        return WeatherApplication.getInstance().getApplicationContext();
    }

   }


