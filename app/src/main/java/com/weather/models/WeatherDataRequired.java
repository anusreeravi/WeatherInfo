package com.weather.models;

/**
 * Created by Anu on 22/02/2018.
 */

public class WeatherDataRequired {

    private String latitude;
    private String longitude;
    private String name;
    private Float temperature;
    private Float humidity;
    private Float precipitationProbability;
    private int  id;

    public WeatherDataRequired(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(Float precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }


}
