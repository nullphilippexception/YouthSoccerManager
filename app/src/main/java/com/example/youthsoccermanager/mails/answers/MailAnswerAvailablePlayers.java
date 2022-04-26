package com.example.youthsoccermanager.mails.answers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.player.Player;
import com.example.youthsoccermanager.dataclasses.player.PlayerFactory;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPreviewValues;
import com.example.youthsoccermanager.layouthelper.PersonPreviewCreator;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.teams.PlayerDisplay;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailAnswerAvailablePlayers extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_mail_contacts_available_players;
    private final int MAIN_VIEW_BODY = R.layout.mail_contacts_available_players;
    private final String PAGE_TITLE = "Chat";
    int contactedCoachId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        contactedCoachId = Integer.parseInt(getIntent().getStringExtra("PERSONNEL_ID")); // to check with database which players to pull
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        displayAvailablePlayers();
    }

    public void help(View view) {

    }

    /*
    * DUMMY METHOD; MAKE ACUTAL DATABASE LOAD LATER ON
    * */
    public void displayAvailablePlayers() {
        Player dummyPlayerOne = PlayerFactory.getPlayerFactory().getTestPlayer(1, "Adam Available", 1);
        HashMap<EPreviewValues, String> playerDataOne = dummyPlayerOne.getPlayerPrintablePreview();
        final int LL_AVAIL_PLAYERS = R.id.mail_contacts_available_players_body;
        PersonPreviewCreator.createTeamPlayerPreview(getLayoutInflater().inflate(R.layout.player_preview, null),
                (LinearLayout)findViewById(LL_AVAIL_PLAYERS), playerDataOne, dummyPlayerOne.getId(), false);
        enableButtonClick(dummyPlayerOne.getId());
    }

    private void enableButtonClick(int playerId) {
        ((Button)findViewById(playerId)).setOnClickListener((View v) -> {
            Intent intent = new Intent(this, PlayerDisplay.class);
            intent.putExtra("PLAYER_ID", String.valueOf(playerId));
            startActivity(intent);
        });
    }


}
