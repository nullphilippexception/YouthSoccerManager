package com.example.youthsoccermanager.todaysevents;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TodaysEvents extends AppCompatActivity implements IHelpProvider {
    private int todaysEventsCounter;
    private final int LL_TITLE_BAR = R.id.title_bar_todays_events;
    private final String PAGE_TITLE = "Today's Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todays_events);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        todaysEventsCounter = 1; // INITIALIZE BASED ON DB INFO, REWRITE THIS; MAYBE OWN METHOD
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        displayEvents();
    }

    public void help(View view) {
        /*
         * CALL Todays Events entry from help library here : use AlertDialog class
         */
        Logger.getAnonymousLogger().log(Level.INFO, "testClick accessed");
        String pageTitle = ((TextView)findViewById(R.id.title_bar_pagetitle)).getText().toString();
        Logger.getAnonymousLogger().log(Level.INFO, "pageTitle String loaded");
        Toast.makeText(this, "TodaysEvents, Page title is: " + pageTitle, Toast.LENGTH_LONG).show();
        Logger.getAnonymousLogger().log(Level.INFO, "testClick done");
    }

    public void startNextDay(View view) {
        if(todaysEventsCounter > 0) {
            Toast.makeText(this,
                    "Finish all of today's activities before starting the next day", Toast.LENGTH_LONG).show();
        }
        else {
            // Start next day
        }
    }

    private void displayEvents() {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.todays_events_body);
        /*
        * pull all events from database that have event_date == date
        * display them
        */
    }
}
