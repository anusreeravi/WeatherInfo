package com.weather.interfaces;

import android.location.Address;

import java.util.List;

/**
 * Created by Anu on 22/02/2018.
 */

    public interface onGeocodeFinishListener {
        public abstract void onFinished(List<Address> results);
    }

