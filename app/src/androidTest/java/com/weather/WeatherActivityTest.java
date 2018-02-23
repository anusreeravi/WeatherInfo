package com.weather;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import com.weather.activities.WeatherActivity;
import com.weather.weatherdetails.WeatherListFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
    public class WeatherActivityTest {

     @Rule
        public ActivityTestRule<WeatherActivity> mActivityRule =
                new ActivityTestRule<>(WeatherActivity.class);

    @Test
    public void fragment_can_be_instantiated() {
        mActivityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setupFragment();
            }
        });

    }

    private WeatherListFragment setupFragment() {
        WeatherActivity activity =  mActivityRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        WeatherListFragment movieListFragment = new WeatherListFragment();
        transaction.add(R.id.fragment_container, movieListFragment);
        transaction.commitAllowingStateLoss();
        return movieListFragment;
    }

    @Test
    public  void visibleRecyclerViewItem() {

        onView(withId(R.id.weather_recyclerview))
                .check(matches(isDisplayed()));
    }



    }
