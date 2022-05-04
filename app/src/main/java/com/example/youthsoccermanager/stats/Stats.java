package com.example.youthsoccermanager.stats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Stats extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_stats;
    private final int MAIN_VIEW_BODY = R.layout.stats;
    private final String PAGE_TITLE = "Stats";

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

    public void goToCompSelection(View view) {
        int buttonId = view.getId();
        EAgeGroup ageGroup = EAgeGroup.U19; //default
        Intent intent = new Intent(this, StatsCompSelection.class);
        switch(buttonId) {
            case R.id.stats_u19:
                break; // u19 is default already
            case R.id.stats_u17:
                ageGroup = EAgeGroup.U17;
                break;
            case R.id.stats_u15:
                ageGroup = EAgeGroup.U15;
                break;
            case R.id.stats_u13:
                ageGroup = EAgeGroup.U13;
                break;
            default:
                Logger.getAnonymousLogger().log(Level.WARNING, "Unknown age group requested");
        }
        intent.putExtra("AGE_GROUP", ageGroup.toString());
        startActivity(intent);
    }
}
