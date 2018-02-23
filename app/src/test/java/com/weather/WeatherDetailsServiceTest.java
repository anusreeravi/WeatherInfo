package com.weather;


import com.weather.webservices.common.WebserviceCallBack;
import com.weather.webservices.services.GetWeatherDetails;

import org.junit.Assert;
import org.junit.Test;


//Test class for webservice for movie details
public class WeatherDetailsServiceTest {


    @Test
    public void getWeatherDetailsTest() {

        new GetWeatherDetails().getCurrentWeatherDetails("51.5074", "0.1278",new WebserviceCallBack() {


            @Override
            public void showProgress() {

            }

            @Override
            public void onSuccess(Object response) {
                Assert.assertNotNull(response);
            }

            @Override
            public void onError(String errorCode) {
                Assert.assertNull(errorCode);
            }

            @Override
            public void onFailed(String response) {
                Assert.assertNull(response);
            }
        });


        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
