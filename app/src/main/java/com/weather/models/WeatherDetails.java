package com.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
  Model class for Retrofit weather request call
 */
public class WeatherDetails {

    public class Alert {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("regions")
        @Expose
        private List<String> regions = null;
        @SerializedName("severity")
        @Expose
        private String severity;
        @SerializedName("time")
        @Expose
        private Integer time;
        @SerializedName("expires")
        @Expose
        private Integer expires;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("uri")
        @Expose
        private String uri;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getRegions() {
            return regions;
        }

        public void setRegions(List<String> regions) {
            this.regions = regions;
        }

        public String getSeverity() {
            return severity;
        }

        public void setSeverity(String severity) {
            this.severity = severity;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getExpires() {
            return expires;
        }

        public void setExpires(Integer expires) {
            this.expires = expires;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

    }


    public class Currently {

        @SerializedName("time")
        @Expose
        private Integer time;
        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("nearestStormDistance")
        @Expose
        private Integer nearestStormDistance;
        @SerializedName("nearestStormBearing")
        @Expose
        private Integer nearestStormBearing;
        @SerializedName("precipIntensity")
        @Expose
        private Float precipIntensity;
        @SerializedName("precipProbability")
        @Expose
        private Float precipProbability;
        @SerializedName("temperature")
        @Expose
        private Float temperature;
        @SerializedName("apparentTemperature")
        @Expose
        private Float apparentTemperature;
        @SerializedName("dewPoint")
        @Expose
        private Float dewPoint;
        @SerializedName("humidity")
        @Expose
        private Float humidity;
        @SerializedName("pressure")
        @Expose
        private Float pressure;
        @SerializedName("windSpeed")
        @Expose
        private Float windSpeed;
        @SerializedName("windGust")
        @Expose
        private Float windGust;
        @SerializedName("windBearing")
        @Expose
        private Integer windBearing;
        @SerializedName("cloudCover")
        @Expose
        private Float cloudCover;
        @SerializedName("uvIndex")
        @Expose
        private Integer uvIndex;
        @SerializedName("visibility")
        @Expose
        private Float visibility;
        @SerializedName("ozone")
        @Expose
        private Float ozone;

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getNearestStormDistance() {
            return nearestStormDistance;
        }

        public void setNearestStormDistance(Integer nearestStormDistance) {
            this.nearestStormDistance = nearestStormDistance;
        }

        public Integer getNearestStormBearing() {
            return nearestStormBearing;
        }

        public void setNearestStormBearing(Integer nearestStormBearing) {
            this.nearestStormBearing = nearestStormBearing;
        }

        public Float getPrecipIntensity() {
            return precipIntensity;
        }

        public void setPrecipIntensity(Float precipIntensity) {
            this.precipIntensity = precipIntensity;
        }

        public Float getPrecipProbability() {
            return precipProbability;
        }

        public void setPrecipProbability(Float precipProbability) {
            this.precipProbability = precipProbability;
        }

        public Float getTemperature() {
            return temperature;
        }

        public void setTemperature(Float temperature) {
            this.temperature = temperature;
        }

        public Float getApparentTemperature() {
            return apparentTemperature;
        }

        public void setApparentTemperature(Float apparentTemperature) {
            this.apparentTemperature = apparentTemperature;
        }

        public Float getDewPoint() {
            return dewPoint;
        }

        public void setDewPoint(Float dewPoint) {
            this.dewPoint = dewPoint;
        }

        public Float getHumidity() {
            return humidity;
        }

        public void setHumidity(Float humidity) {
            this.humidity = humidity;
        }

        public Float getPressure() {
            return pressure;
        }

        public void setPressure(Float pressure) {
            this.pressure = pressure;
        }

        public Float getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(Float windSpeed) {
            this.windSpeed = windSpeed;
        }

        public Float getWindGust() {
            return windGust;
        }

        public void setWindGust(Float windGust) {
            this.windGust = windGust;
        }

        public Integer getWindBearing() {
            return windBearing;
        }

        public void setWindBearing(Integer windBearing) {
            this.windBearing = windBearing;
        }

        public Float getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(Float cloudCover) {
            this.cloudCover = cloudCover;
        }

        public Integer getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(Integer uvIndex) {
            this.uvIndex = uvIndex;
        }

        public Float getVisibility() {
            return visibility;
        }

        public void setVisibility(Float visibility) {
            this.visibility = visibility;
        }

        public Float getOzone() {
            return ozone;
        }

        public void setOzone(Float ozone) {
            this.ozone = ozone;
        }

    }


        @SerializedName("latitude")
        @Expose
        private Float latitude;
        @SerializedName("longitude")
        @Expose
        private Float longitude;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("currently")
        @Expose
        private Currently currently;
        @SerializedName("alerts")
        @Expose
        private List<Alert> alerts = null;
        @SerializedName("offset")
        @Expose
        private Integer offset;

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Currently getCurrently() {
            return currently;
        }

        public void setCurrently(Currently currently) {
            this.currently = currently;
        }

        public List<Alert> getAlerts() {
            return alerts;
        }

        public void setAlerts(List<Alert> alerts) {
            this.alerts = alerts;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

    }

