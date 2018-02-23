package com.weather.weatherdetails;


import com.weather.app.WeatherApplication;
import com.weather.dbcontroller.DatabaseManager;
import com.weather.dbcontroller.FileDataProvider;
import com.weather.models.WeatherDataRequired;
import com.weather.models.WeatherDetails;
import com.weather.webservices.common.WebserviceCallBack;
import com.weather.webservices.services.GetWeatherDetails;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/*
Presenter class for fetching weather info
 */
public class WeatherDetailsPresenter implements WeatherDetailsContract.Presenter {

    private final int LIST_SIZE = 5;
    private WeatherDetailsContract.View weatherView;
    private WeatherDetails weatherDetails;
    private List<WeatherDataRequired> weatherDataRequiredList = new ArrayList<>();
    @Inject
    DatabaseManager dbManager;
    @Inject
    FileDataProvider dataProvider;

    public WeatherDetailsPresenter(WeatherDetailsContract.View view) {
        weatherView = view;
        WeatherApplication.getInstance().getComponent().inject(this);
    }

    @Override
    public void onPageLoaded() {
        weatherView.showProgress();
        fetchWeatherInfo();

    }




    private void fetchWeatherInfo() {
        try {
            List<WeatherDataRequired> weatherDataList = dataProvider.populateList();
            if (weatherDataList == null)
                populatefromDB();
            else {
                weatherView.showProgress();

                for (final WeatherDataRequired weatherDataRequired : weatherDataList) {

                    new GetWeatherDetails().getCurrentWeatherDetails(weatherDataRequired.getLatitude(), weatherDataRequired.getLongitude(), new WebserviceCallBack() {

                        @Override
                        public void showProgress() {
                        }

                        @Override
                        public void onSuccess(Object response) {
                            weatherDetails = (WeatherDetails) response;
                            weatherDataRequired.setTemperature(weatherDetails.getCurrently().getTemperature());
                            weatherDataRequired.setPrecipitationProbability(weatherDetails.getCurrently().getPrecipProbability());
                            weatherDataRequired.setHumidity(weatherDetails.getCurrently().getHumidity());

                            weatherDataRequired.setTemperature(weatherDetails.getCurrently().getTemperature());
                            weatherDataRequiredList.add(weatherDataRequired);
                            if (weatherDataRequiredList.size() == LIST_SIZE) {
                                dbManager.saveDB(weatherDataRequiredList);

                                weatherView.showWeatherDetails(weatherDataRequiredList);
                                weatherView.dismissProgress();
                            }


                        }

                        @Override
                        public void onError(String errorCode) {
                            weatherView.dismissProgress();
                        }

                        @Override
                        public void onFailed(String response) {
                            weatherView.dismissProgress();
                        }
                    });

                }
                }
            }catch(Exception e){

            }

    }

    private void populatefromDB(){
        weatherDataRequiredList=dbManager.getAllData();
        weatherView.showWeatherDetails(weatherDataRequiredList);
        weatherView.dismissProgress();
        }

}

