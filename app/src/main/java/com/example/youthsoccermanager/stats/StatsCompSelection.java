package com.example.youthsoccermanager.stats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StatsCompSelection extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_stats_competition_selection;
    private final int MAIN_VIEW_BODY = R.layout.stats_competition_selection;
    private final String PAGE_TITLE = "Competitions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
    }

    public void help(View view) {
        // call help menu entry here
    }

    public void goToSpecifiedStats(View view) {
        int buttonId = view.getId();
        EAgeGroup ageGroup = getIntent().getParcelableExtra("AGE_GROUP"); // CHECK IF CORRECT! -> maybe put this in ctor for title use
        Intent intent = getIntent();
        intent.putExtra("AGE_GROUP", ageGroup); // easier design?
        switch(buttonId) {
            case R.id.stats_comp_selection_league:
                intent.setClass(this, StatsLeague.class);
                break;
            case R.id.stats_comp_selection_cup:
                intent.setClass(this, StatsCup.class);
                break;
            case R.id.stats_comp_selection_europe_cup:
                Toast.makeText(this, "You have to unlock international competitions first!", Toast.LENGTH_LONG);
                intent.setClass(this, StatsCompSelection.class); // think about something better for this in terms of protection
                //intent.setClass(this, StatsIntCup.class); // only if unlocked already -> DO IF HERE
                break;
            case R.id.stats_comp_selection_myteam:
                intent.setClass(this, StatsMyTeam.class);
                break;
            default:
                Logger.getAnonymousLogger().log(Level.WARNING, "Unknown age group requested");
        }
        startActivity(intent);
    }
}
