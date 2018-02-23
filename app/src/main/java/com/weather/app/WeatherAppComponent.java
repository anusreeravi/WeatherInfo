package com.weather.app;

/**
 * App Component for Dependency Injection
 */

import com.weather.weatherdetails.WeatherDetailsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = WeatherAppModule.class)
public interface WeatherAppComponent {
    void inject(WeatherDetailsPresenter presenter);
}
