package com.weather.weatherdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weather.R;
import com.weather.models.WeatherDataRequired;

import java.util.List;


/*
Adapter class for populating current weather for cities
 */
public class WeatherAdapter extends RecyclerView.Adapter

{
    //For showing degree celsius
    private static final String DEGREE ="&#xb0;";

    private List<WeatherDataRequired> weatherDetailsList;
    private WeatherDetailsContract.Presenter weatherListPresenter;
    private Context context;
    public WeatherAdapter(Context context, List<WeatherDataRequired> weatherDetailsList, WeatherDetailsContract.Presenter presenter) {
        this.weatherDetailsList = weatherDetailsList;
        this.weatherListPresenter = presenter;
        this.context =context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WeatherViewHolder(parent);
    }

    /*
      Binding data to views
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final WeatherViewHolder viewHolder = (WeatherViewHolder) holder;
        final WeatherDataRequired weatherDetails = weatherDetailsList.get(position);
        viewHolder.title.setText(weatherDetails.getName());

        viewHolder.rainPercent.setText((weatherDetails.getPrecipitationProbability()*100)+" %");
        viewHolder.humidityPercent.setText((weatherDetails.getHumidity()*100)+" %" );
        viewHolder.temperature.setText((Html.fromHtml((""+weatherDetails.getTemperature())+ DEGREE +"C" )));

        //setWeatherIcon(viewHolder.weatherIcon, weatherDetails.g());

    }


    @Override
    public int getItemCount() {

        return weatherDetailsList.size();
    }


    private class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView rainPercent;
        TextView humidityPercent;
        TextView temperature;
        RelativeLayout weatherLayout;
        //ImageView weatherIcon;
        public WeatherViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false));
            title = (TextView) itemView.findViewById(R.id.title);
            rainPercent = (TextView) itemView.findViewById(R.id.rainpercent);
            humidityPercent = (TextView) itemView.findViewById(R.id.humiditypercent);
            temperature = (TextView) itemView.findViewById(R.id.temperature);

            weatherLayout = (RelativeLayout) itemView.findViewById(R.id.weatherLayout);
           // weatherIcon = (ImageView) itemView.findViewById(R.id.weatherIcon);

        }


    }


/*

    public void getCityName(final float latitude,final float longitude, final onGeocodeFinishListener listener) {
        new AsyncTask<Void, Integer, List<Address>>() {
            @Override
            protected List<Address> doInBackground(Void... arg0) {
                Geocoder coder = new Geocoder(context, Locale.getDefault());
                List<Address> results = null;
                try {
                    results = coder.getFromLocation(latitude, longitude, 1);
                } catch (IOException e) {
                }
                return results;
            }

            @Override
            protected void onPostExecute(List<Address> results) {
                if (results != null && listener != null) {
                    listener.onFinished(results);
                }
            }
        }.execute();
    }

*/


}