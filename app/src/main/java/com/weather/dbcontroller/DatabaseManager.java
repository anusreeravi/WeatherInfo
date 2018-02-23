package com.weather.dbcontroller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.weather.models.WeatherDataRequired;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/*
   Database Manager class where values are populated and fetched from database
 */
public class DatabaseManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "city";
    // tasks table name
    private static final String TABLE_CITY = "city_table";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LON = "lon";
    private static final String KEY_TEMP = "temperature";
    private static final String KEY_RAIN = "rain";
    private static final String KEY_HUMIDITY = "humidity";



    @Inject
    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
       Creating table
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //    dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_CITY + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
                + " TEXT, " + KEY_LAT
                + " TEXT, "+ KEY_LON
                + " TEXT, "+ KEY_TEMP
                + " TEXT, "+ KEY_HUMIDITY
                + " TEXT, "+ KEY_RAIN
                + " TEXT)";
        db.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY);
    // Create tables again
        onCreate(db);
    }



    /*
      Adding details to DB
     */
    public void saveDB(List<WeatherDataRequired> details) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_CITY,null,null);
            for(WeatherDataRequired weatherDataRequired:details) {
                ContentValues values = new ContentValues();
                values.put(KEY_NAME, weatherDataRequired.getName());
                values.put(KEY_LAT, weatherDataRequired.getLatitude());
                values.put(KEY_LON, weatherDataRequired.getLongitude());
                values.put(KEY_HUMIDITY, String.valueOf(weatherDataRequired.getHumidity()));
                values.put(KEY_RAIN, String.valueOf(weatherDataRequired.getPrecipitationProbability()));
                values.put(KEY_TEMP,String.valueOf(weatherDataRequired.getTemperature()));
                // Inserting Row
                db.insert(TABLE_CITY, null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    /*
      Fetching data from DB
     */
    public List<WeatherDataRequired> getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<WeatherDataRequired> weatherDetailsList = new ArrayList<>();

        try {
// Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_CITY;
            Cursor cursor = db.query(TABLE_CITY,null, null,null,null,null,null);
// looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    WeatherDataRequired weatherDataRequired = new WeatherDataRequired();

                    weatherDataRequired.setName(cursor.getString(1));
                    weatherDataRequired.setLatitude(cursor.getString(2));
                    weatherDataRequired.setLongitude(cursor.getString(3));
                    weatherDataRequired.setTemperature(Float.valueOf(cursor.getString(4)));
                    weatherDataRequired.setHumidity(Float.valueOf(cursor.getString(5)));

                    weatherDataRequired.setPrecipitationProbability(Float.valueOf(cursor.getString(6)));

                    weatherDataRequired.setName(cursor.getString(1));
                    weatherDataRequired.setLatitude(cursor.getString(2));
                    weatherDataRequired.setLongitude(cursor.getString(3));

                    weatherDetailsList.add(weatherDataRequired);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return weatherDetailsList;
    }
    /*public String getCityName(String lat,String lon) {
        SQLiteDatabase db = this.getReadableDatabase();
        String cityName="";
        try {
// Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_CITY +" WHERE "+KEY_LAT+" = '"+lat +"' AND "+KEY_LON+" = '"+lon+"'";
            Cursor cursor = db.rawQuery(selectQuery, null);
            db.query(TABLE_CITY, null, KEY_LAT + "=? AND " + KEY_LON + "=?", new String[]{lat, lon}, null, null, null);
// looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    cityName = (cursor.getString(1));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return cityName;
    }*/

}

