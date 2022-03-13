package com.example.youthsoccermanager.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teams extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_teams;
    private final int MAIN_VIEW_BODY = R.layout.teams;
    private final String PAGE_TITLE = "Teams";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        updatePlayerAndRatingInfo();
    }

    public void help(View view) {

    }

    public void goToSquad(View view) {
        HashMap<Integer, String> listOfSquadTitles = new HashMap<>();
        listOfSquadTitles.put(R.id.teams_u19_btn, "U19");
        listOfSquadTitles.put(R.id.teams_u17_btn, "U17");
        listOfSquadTitles.put(R.id.teams_u15_btn, "U15");
        listOfSquadTitles.put(R.id.teams_u13_btn, "U13");
        String squadTitleToHandOver = listOfSquadTitles.get(((Button)view).getId());

        Intent intent = new Intent(this, SquadList.class);
        intent.putExtra("SQUAD_TITLE", squadTitleToHandOver);
        startActivity(intent);
    }

    private void updatePlayerAndRatingInfo() {
        
    }
}
