package com.weather.dbcontroller;

import android.content.Context;
import android.content.res.AssetManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.weather.models.WeatherDataRequired;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by Anu on 23/02/2018.
 */

public class FileDataProvider {

    private Context context;

    @Inject
    public FileDataProvider(Context context){
        this.context=context;

    }

    private boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }catch(Exception ex){

            ex.printStackTrace();
            return false;
        }
    }
    public List<WeatherDataRequired> populateList(){
        if(isNetworkAvailable()) {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = null;
            try {
                inputStream = assetManager.open("cities.xml");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            ArrayList<String> cityList = readXml(inputStream);
            List<WeatherDataRequired> weatherDataRequiredList = setCoordinates(cityList);
            return weatherDataRequiredList;
        }
       return null;
    }


    private ArrayList<String> readXml( InputStream inputStream ){
        ArrayList<String> cityList = new ArrayList<>();
        try {

            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlFactoryObject.newPullParser();
            xmlPullParser.setInput(inputStream, null);
            int event = xmlPullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT)  {
                String name=xmlPullParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.END_TAG:
                        if(name.equals("city")) {
                            cityList.add(xmlPullParser.getAttributeValue(null, "name"));
                        }
                        break;
                }
                event = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cityList;
    }



    private List<WeatherDataRequired> setCoordinates(ArrayList<String> cityList) {
        List<WeatherDataRequired> weatherDataList  =new ArrayList<>();
        for (String city : cityList) {

            Geocoder geoCoder = new Geocoder(context, Locale.getDefault());

            try {
                List<Address> addresses =
                        geoCoder.getFromLocationName(city, 1);
                if (addresses.size() > 0) {
                    WeatherDataRequired weatherDataRequired = new WeatherDataRequired();
                    weatherDataRequired.setName(city);
                    weatherDataRequired.setLatitude("" + addresses.get(0).getLatitude());
                    weatherDataRequired.setLongitude("" + addresses.get(0).getLongitude());

                    weatherDataList.add(weatherDataRequired);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return weatherDataList;
    }

}
