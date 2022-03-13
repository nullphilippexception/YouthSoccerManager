package com.example.youthsoccermanager.teams;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.Player;
import com.example.youthsoccermanager.dataclasses.PlayerFactory;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerDisplay extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_player_display;
    private final int MAIN_VIEW_BODY = R.layout.player_display;
    private final String PAGE_TITLE = "Player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded");
        int playerId = Integer.parseInt(getIntent().getStringExtra("PLAYER_ID"));
        displayPlayerFromDB(playerId);
    }

    public void help(View view) {

    }

    // DUMMY METHOD -> IMPLEMENT LATER
    private void displayPlayerFromDB(int playerId) {
        /*
        * check whether this playerid belongs to my squad
        * otherwise enter question marks / indicators?
        * */
        Player dummyPlayerOne = PlayerFactory.getPlayerFactory().getTestPlayer(1, "Testy Test", 1);
        Player dummyPlayerTwo = PlayerFactory.getPlayerFactory().getTestPlayer(2, "Testname Misterverylongname", 2);
        Map<Integer, Player> testList = new HashMap<>();
        testList.put(dummyPlayerOne.getId(), dummyPlayerOne);
        testList.put(dummyPlayerTwo.getId(),  dummyPlayerTwo);
        printPlayerToScreen(testList.get(playerId).getPlayerPrintableData());
    }

    private void printPlayerToScreen(HashMap<Integer, String> playerData) {
        List<Integer> viewIdList = getAllViewIds();
        for(int currentView : viewIdList) {
            ((TextView)findViewById(currentView)).setText(playerData.get(currentView));
        }
    }

    private List<Integer> getAllViewIds() {
        return Arrays.asList(R.id.player_display_namenr,
                R.id.player_display_position,
                R.id.player_display_ovr,
                R.id.player_display_nationality,
                R.id.player_display_exp,
                R.id.player_display_agesalarycontract,
                R.id.player_display_speed,
                R.id.player_display_strength,
                R.id.player_display_intelligence,
                R.id.player_display_goalkeeping,
                R.id.player_display_defending,
                R.id.player_display_dribbling,
                R.id.player_display_passing,
                R.id.player_display_shooting,
                R.id.player_display_fitness,
                R.id.player_display_morale,
                R.id.player_display_attitude,
                R.id.player_display_goals,
                R.id.player_display_assists,
                R.id.player_display_gamesC,
                R.id.player_display_gamesF,
                R.id.player_display_minutesC,
                R.id.player_display_minutesF);
    }
}
