package com.example.youthsoccermanager.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.Player;
import com.example.youthsoccermanager.dataclasses.PlayerFactory;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPreviewValues;
import com.example.youthsoccermanager.layouthelper.PersonPreviewCreator;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SquadList extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_squadlist;
    private final int MAIN_VIEW_BODY = R.layout.squadlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        final String PAGE_TITLE = getIntent().getStringExtra("SQUAD_TITLE") + " Squad";
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        getPlayersFromDB();
    }

    public void help(View view) {

    }

    // DUMMY METHOD - fill in with real info (loop for players from db) later on
    private void getPlayersFromDB() {
        Player dummyPlayerOne = PlayerFactory.getPlayerFactory().getTestPlayer(1, "Testy Test", 1);
        Player dummyPlayerTwo = PlayerFactory.getPlayerFactory().getTestPlayer(2, "Testname Misterverylongname", 2);
        HashMap<EPreviewValues, String> playerDataOne = dummyPlayerOne.getPlayerPrintablePreview();
        HashMap<EPreviewValues, String> playerDataTwo = dummyPlayerTwo.getPlayerPrintablePreview();
        final int LL_SQUADLIST = R.id.squadlist_body;
        PersonPreviewCreator.createTeamPlayerPreview(getLayoutInflater().inflate(R.layout.player_preview, null),
                (LinearLayout)findViewById(LL_SQUADLIST), playerDataOne, dummyPlayerOne.getId(), true);
        enableButtonClick(dummyPlayerOne.getId());
        PersonPreviewCreator.createTeamPlayerPreview(getLayoutInflater().inflate(R.layout.player_preview, null),
                (LinearLayout)findViewById(LL_SQUADLIST), playerDataTwo, dummyPlayerTwo.getId(), true);
        enableButtonClick(dummyPlayerTwo.getId());
    }

    private void enableButtonClick(int playerId) {
        ((Button)findViewById(playerId)).setOnClickListener((View v) -> {
            Intent intent = new Intent(this, PlayerDisplay.class);
            intent.putExtra("PLAYER_ID", String.valueOf(playerId));
            startActivity(intent);
        });
    }


}
