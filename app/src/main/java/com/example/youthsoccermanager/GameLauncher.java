package com.example.youthsoccermanager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.youthsoccermanager.dataclasses.admin.GlobalGameVar;
import com.example.youthsoccermanager.gamecreation.CreatorMailDB;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.gamecreation.database.GlobalGameVarDAO;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;

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

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
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
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("date", "01-July"));
            gameVarDAO.setGlobalGameVar(new GlobalGameVar("money", "2000"));
        }
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }

        // MAILS
        CreatorMailDB.createInitialMails();
        ((TextView)findViewById(R.id.launch_mails)).setTextColor(Color.rgb(0,100,0));
        ((TextView)findViewById(R.id.launch_mails)).setText("Mails created");
    }

    private void showSteps() {
        ((TextView)findViewById(R.id.launch_mails)).setVisibility(View.VISIBLE);
    }

}
