package com.weather.weatherdetails;

import com.weather.models.WeatherDataRequired;

import java.util.List;


 /*
   Contract for weather detail view for populating data
 */
public interface WeatherDetailsContract {

    public interface View {
        void showWeatherDetails(List<WeatherDataRequired> details);
        void showProgress();
        void dismissProgress();
    }

    public interface Presenter {
        void onPageLoaded();
    }
}
