package com.weather.webservices.common;

/*
   Callback Interface for updating in view
 */
public interface WebserviceCallBack {
    void showProgress();

    void onSuccess(Object response);

    void onError(String errorCode);

    void onFailed(String response);

}
