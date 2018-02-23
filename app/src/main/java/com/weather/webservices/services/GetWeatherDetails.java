package com.weather.webservices.services;


import com.weather.app.WeatherApplication;
import com.weather.models.WeatherDetails;
import com.weather.webservices.common.WebserviceCallBack;
import com.weather.webservices.common.WebserviceHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


public class GetWeatherDetails extends WebserviceHelper {

    private final String EXCLUDE_FLAGS="daily,minutely,hourly,flags";
    private final String  UNITS_SI = "si";
    private final String  WEATHER_URL = "forecast/";

    public void getCurrentWeatherDetails(String latitude,String longitude,WebserviceCallBack callBack) {
        String url=WEATHER_URL+ WeatherApplication.getInstance().getApiKey()+"/"+latitude+","+longitude;
        Call<WeatherDetails> payloadCall = createEndpoint(WeatherEndpoints.class).getWeatherData(url,EXCLUDE_FLAGS,UNITS_SI);
        executeWebservice(payloadCall, callBack);
    }


    public interface WeatherEndpoints {
        @GET
        Call<WeatherDetails> getWeatherData(@Url String url, @Query("exclude") String flags, @Query("units") String unit);

    }




}
