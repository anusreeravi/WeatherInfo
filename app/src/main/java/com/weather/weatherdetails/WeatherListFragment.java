package com.weather.weatherdetails;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.R;
import com.weather.models.WeatherDataRequired;

import java.util.List;


/*##
Fragment class for viewing weather data
 */
public class WeatherListFragment extends Fragment implements WeatherDetailsContract.View {
    private final String LOADING = "Loading...";

    private WeatherDetailsPresenter weatherDetailsPresenter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherDetailsPresenter = new WeatherDetailsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(LOADING);
        progressDialog.setCancelable(false);
        inflateViews(rootView);
        return rootView;
    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Tells presenter that screen is loaded to show content

        weatherDetailsPresenter.onPageLoaded();
    }

    @Override
    public void showWeatherDetails(List<WeatherDataRequired> weatherDetailsList ) {
        populateList(weatherDetailsList);

    }

    /*
     Binding view with adapter
     */
    private void populateList(List<WeatherDataRequired> weatherDetailsList) {
        if (weatherAdapter == null) {
            weatherAdapter = new WeatherAdapter(getActivity(),weatherDetailsList,weatherDetailsPresenter);
            recyclerView.setAdapter(weatherAdapter);
        }
        weatherAdapter.notifyDataSetChanged();
    }


    @Override
    public void showProgress() {
        //TODO Can be used to show loading progress
        if(progressDialog!=null)
            progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        //TODO can be used to dismiss any existing progress dialog
        if(progressDialog!=null && progressDialog.isShowing())
            progressDialog.dismiss();

    }


/*
Grid layout with Recyclerview for grid style
 */
    private void inflateViews(View rootView){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.weather_recyclerview);
        progressDialog = new ProgressDialog(getActivity());

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setUpItemTouchHelper();
    }
    private void setUpItemTouchHelper() {

        ItemTouchHelper SimpleItemTouchHelperCallback = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            }
        });
        SimpleItemTouchHelperCallback.attachToRecyclerView(recyclerView);
    }


}
