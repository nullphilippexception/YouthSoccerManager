package com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.events.ClubFestivity;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.events.PublicTryout;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.events.SpecialTalentGroup;
import com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting.events.TrainingCamp;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleEvent extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_scouting_schedule_event;
    private final int MAIN_VIEW_BODY = R.layout.scouting_schedule_event;
    private final String PAGE_TITLE = "Events";

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

    public void goToEvent(View view) {
        Intent intent = getIntent();
        int selectedId = view.getId();
        switch(selectedId) {
            case R.id.scouting_event_public_tryout:
                intent.setClass(this, PublicTryout.class);
                break;
            case R.id.scouting_event_training_camp:
                intent.setClass(this, TrainingCamp.class);
                break;
            case R.id.scouting_event_special_talent_group:
                intent.setClass(this, SpecialTalentGroup.class);
                break;
            case R.id.scouting_event_special_club_festivity:
                intent.setClass(this, ClubFestivity.class);
                break;
            default:
                Logger.getAnonymousLogger().log(Level.WARNING, "Unknown scouting event type requested");
                Toast.makeText(this, "Unknown scouting event type requested", Toast.LENGTH_LONG);
        }
        startActivity(intent);
    }
}
