package com.weather.webservices.common;


public interface WebserviceCallBack {
    void showProgress();

    void onSuccess(Object response);

    void onError(String errorCode);

    void onFailed(String response);

}
