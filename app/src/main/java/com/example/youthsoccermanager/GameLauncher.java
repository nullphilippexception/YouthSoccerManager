package com.example.youthsoccermanager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.youthsoccermanager.dataclasses.admin.GlobalGameVar;
import com.example.youthsoccermanager.dataclasses.admin.Team;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.ELeague;
import com.example.youthsoccermanager.gamecreation.CreatorMailDB;
import com.example.youthsoccermanager.gamecreation.CreatorTeamDB;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.gamecreation.database.GlobalGameVarDAO;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameLauncher extends AppCompatActivity {
    /**
     * onCreate is called when the activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_launcher);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createGame(View view) {
        try {
            showSteps();
            startingScript();
        }
        catch (Exception e) {
            Toast.makeText(this, "Ooops! Sorry, something went wrong. Please try again.", Toast.LENGTH_LONG);
            Logger.getAnonymousLogger().log(Level.SEVERE, "Error in game creation, message: " + e.getMessage());
        }
    }

    public void loadGame(View view) {
        /*
        * LATER: check if a game exists already
        * - if yes: load this game
        * - if not: Toast that loading game not successful because there is no game*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startingScript() throws Exception {
        GameDatabase.init(getApplicationContext());
        GlobalGameVarDAO gameVarDAO = GameDatabase.getDB().gameVarDAO();
        try {
            // CREATE enum for gamevar names?
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("date", "01-July"));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("money", "2000"));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("u19league", ELeague.CityLeagueIII.toString()));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("u17league", ELeague.CityLeagueIII.toString()));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("u15league", ELeague.CityLeagueIII.toString()));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("u13league", ELeague.CityLeagueIII.toString()));
        }
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }

        // MAILS
        CreatorMailDB.createInitialMails();
        ((TextView)findViewById(R.id.launch_mails)).setTextColor(Color.rgb(0,100,0));
        ((TextView)findViewById(R.id.launch_mails)).setText("Mails created");

        // TEAMS
        CreatorTeamDB.createTeams();
        ((TextView)findViewById(R.id.launch_teams)).setTextColor(Color.rgb(0,100,0));
        ((TextView)findViewById(R.id.launch_teams)).setText("Teams created");

        // ...

        // FINAL STEP
        askForUserTeamName();
    }

    private void showSteps() {
        ((TextView)findViewById(R.id.launch_mails)).setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.launch_teams)).setVisibility(View.VISIBLE);
    }

    private void askForUserTeamName() {
        ((TextView)findViewById(R.id.hint_user_teamname)).setVisibility(View.VISIBLE);
        ((EditText)findViewById(R.id.edittext_user_teamname)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.button_user_create)).setVisibility(View.VISIBLE);
    }

    public void startCreatedGame(View view) {
        // PROTECT AGAINST SQL INJECTION HERE!
        String userTeamName = ((EditText)findViewById(R.id.edittext_user_teamname)).getText().toString();
        // MAYBE CREATE ID IN TEAM - OR CHECK FOR DUPLICATES HERE! - jsut rename computer team that has this name?
        // MAYBE ADD UXX TO TEAM NAME?
        List<String> ageGroups = Arrays.asList(EAgeGroup.U19.toString(), EAgeGroup.U17.toString(), EAgeGroup.U15.toString(),
                EAgeGroup.U13.toString());
        for(String ageGroup : ageGroups) {
            Team userTeam = new Team(userTeamName + " " + ageGroup, ELeague.CityLeagueIII.toString(), ageGroup, 0,0,
                    0,0);
            GameDatabase.getDB().teamDAO().insertTeam(userTeam);
        }
        Logger.getAnonymousLogger().log(Level.INFO, "User team created, name: " + userTeamName);
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }



}
