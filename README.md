## WeatherInfo
Weather Android App for a given set of cities using dark sky API https://darksky.net/

#### Used libraries:

  com.android.support.constraint:constraint-layout:1.0.2,
   junit:junit:4.12 ,
   com.android.support:appcompat-v7:25.3.0 ,
   com.android.support:design:25.3.0,
   com.android.support:support-v4:25.3.0,
   com.squareup.retrofit2:retrofit:2.2.0,
   com.squareup.retrofit2:converter-gson:2.2.0,
   com.squareup.okhttp3:logging-interceptor:3.5.0,
   com.android.support:support-annotations:24.2.0,
   com.google.dagger:dagger-android:2.11.
   
#### Prerequisite:
Create an account in https://darksky.net/ and  generate  API Key for requesting weather details from API.

API_KEY is stored in Application class.


#### Task list
1. Creating Xml file, saving city details and fetching latitude and longitude for each city after reading file 

2. Fetching Data from API giving latitude and longitude details

3. Populating list of cities with the corresponding weather data

4. Saving to database after fetching data

5. Loading data for previous visit if any from database if device is offline.


