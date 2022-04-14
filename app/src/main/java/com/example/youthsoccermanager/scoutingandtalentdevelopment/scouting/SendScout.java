package com.example.youthsoccermanager.scoutingandtalentdevelopment.scouting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SendScout extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_scouting_send_scout;
    private final int MAIN_VIEW_BODY = R.layout.scouting_send_scout;
    private final String PAGE_TITLE = "Send Scout";

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

    public void showGames(View view) {
        int buttonId = view.getId();
        EAgeGroup AGE_GROUP = EAgeGroup.U19; // default value
        if(buttonId == R.id.scouting_send_scout_u19) {
            AGE_GROUP = EAgeGroup.U19; // to have it complete
        }
        if(buttonId == R.id.scouting_send_scout_u17) {
            AGE_GROUP = EAgeGroup.U17; // to have it complete
        }
        if(buttonId == R.id.scouting_send_scout_u15) {
            AGE_GROUP = EAgeGroup.U15; // to have it complete
        }
        if(buttonId == R.id.scouting_send_scout_u13) {
            AGE_GROUP = EAgeGroup.U13; // to have it complete
        }
        if(buttonId == R.id.scouting_send_scout_u11) {
            AGE_GROUP = EAgeGroup.U11; // to have it complete
        }
        Intent intent = new Intent(this, ScoutableLeagues.class);
        intent.putExtra("AGE_GROUP", AGE_GROUP);
        startActivity(intent);
    }
}
