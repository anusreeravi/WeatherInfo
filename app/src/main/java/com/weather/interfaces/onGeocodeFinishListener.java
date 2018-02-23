package com.weather.interfaces;

import android.location.Address;

import java.util.List;



   /*
      Interface for notifying geocode network is finished or not
    */
    public interface onGeocodeFinishListener {
        public abstract void onFinished(List<Address> results);
    }

