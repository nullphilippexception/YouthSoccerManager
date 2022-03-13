package com.example.youthsoccermanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youthsoccermanager.calendar.Calendar;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.mails.Mails;
import com.example.youthsoccermanager.personnelandfinance.PersonnelAndFinance;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.ScoutingAndTalentDevelopment;
import com.example.youthsoccermanager.settingsandtutorials.SettingsAndTutorials;
import com.example.youthsoccermanager.stats.Stats;
import com.example.youthsoccermanager.teams.Teams;
import com.example.youthsoccermanager.todaysevents.TodaysEvents;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_main_menu;
    private final String PAGE_TITLE = "Main Menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    public void help(View view) {
        /*
        * CALL Main Menu entry from help library here : use AlertDialog class
        */
        Logger.getAnonymousLogger().log(Level.INFO, "testClick accessed");
        String pageTitle = ((TextView)findViewById(R.id.title_bar_pagetitle)).getText().toString();
        Logger.getAnonymousLogger().log(Level.INFO, "pageTitle String loaded");
        Toast.makeText(this, "MainMenu, Page title is: " + pageTitle, Toast.LENGTH_LONG).show();
        Logger.getAnonymousLogger().log(Level.INFO, "testClick done");
    }

    public void goToTodaysEvents(View view) {
        Intent intent = new Intent(this, TodaysEvents.class);
        startActivity(intent);
    }

    public void goToCalendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    public void goToMails(View view) {
        Intent intent = new Intent(this, Mails.class);
        startActivity(intent);
    }

    public void goToTeams(View view) {
        Intent intent = new Intent(this, Teams.class);
        startActivity(intent);
    }

    public void goToPersonnelAndFinance(View view) {
        Intent intent = new Intent(this, PersonnelAndFinance.class);
        startActivity(intent);
    }

    public void goToScoutingAndTalentDevelopment(View view) {
        Intent intent = new Intent(this, ScoutingAndTalentDevelopment.class);
        startActivity(intent);
    }

    public void goToStats(View view) {
        Intent intent = new Intent(this, Stats.class);
        startActivity(intent);
    }

    public void goToSettingsAndTutorials(View view) {
        Intent intent = new Intent(this, SettingsAndTutorials.class);
        startActivity(intent);
    }
}