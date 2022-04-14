package com.example.youthsoccermanager.scoutingandtalentdevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.ScheduleEvent;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.SelectionData;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.SendScout;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.Watchlist;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoutingAndTalentDevelopment extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_scouting;
    private final int MAIN_VIEW_BODY = R.layout.scouting;
    private final String PAGE_TITLE = "Scouting & TD";

    /**
     * onCreate is called when the activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    public void help(View view) {

    }

    public void openWatchlist(View view) {
        Intent intent = new Intent(this, Watchlist.class);
        startActivity(intent);
    }

    public void sendScout(View view) {
        Intent intent = new Intent(this, SendScout.class);
        startActivity(intent);
    }

    public void scheduleEvent(View view) {
        Intent intent = new Intent(this, ScheduleEvent.class);
        startActivity(intent);
    }

    public void showSelectionSquadData(View view) {
        Intent intent = new Intent(this, SelectionData.class);
        startActivity(intent);
    }
}
