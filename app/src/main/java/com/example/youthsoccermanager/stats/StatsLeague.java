package com.example.youthsoccermanager.stats;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.admin.Team;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;
import com.example.youthsoccermanager.layouthelper.TitleBarSetter;
import com.example.youthsoccermanager.userhelplibrary.IHelpProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatsLeague extends AppCompatActivity implements IHelpProvider {
    private final int LL_TITLE_BAR = R.id.title_bar_stats_league;
    private final int MAIN_VIEW_BODY = R.layout.stats_league;
    private final String PAGE_TITLE = "League";
    private String ageGroup;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MAIN_VIEW_BODY);
        TitleBarSetter.postTitleBar(getLayoutInflater().inflate(R.layout.title_bar, null),
                (LinearLayout)findViewById(LL_TITLE_BAR), PAGE_TITLE);
        ageGroup = getIntent().getStringExtra("AGE_GROUP"); // does this work?
        Logger.getAnonymousLogger().log(Level.INFO, "Basic page loaded, ageGroup: ");
        displayLeagueTable();
    }

    public void help(View view) {
        // call help menu entry here
    }

    // SPLIT THIS UP IN SEVERAL METHODS
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayLeagueTable() {
        String leagueType = "u19league"; // default
        switch(ageGroup) {
            case "U19":
                leagueType = GameDatabase.getDB().gameVarDAO().getU19League().getValue();
                break;
            case "U17":
                leagueType = GameDatabase.getDB().gameVarDAO().getU17League().getValue();
                break;
            case "U15":
                leagueType = GameDatabase.getDB().gameVarDAO().getU15League().getValue();
                break;
            case "U13":
                leagueType = GameDatabase.getDB().gameVarDAO().getU13League().getValue();
                break;
            default:
                Logger.getAnonymousLogger().log(Level.WARNING, "Requested non-existing league type");
        }
        List<Team> teams = new ArrayList<>();
        teams.addAll(GameDatabase.getDB().teamDAO().getAllInLeagueForAgeGroup(leagueType, ageGroup));
        Logger.getAnonymousLogger().log(Level.INFO, "Successfully fetched " + teams.size() + " teams of age group " +
                ageGroup + " in league " + leagueType);

        // usually sort by points here first - is this the right order?
        List<Team> sortedTeams = teams.stream()
                                    .sorted((team1, team2) -> team1.getLeaguePoints() - team2.getLeaguePoints())
                                    .collect(Collectors.toList());

        addTeamsToTable(sortedTeams);
    }

    private void addTeamsToTable(List<Team> sortedTeams) {
        int rank = 1;
        LinearLayout numbers = ((LinearLayout) findViewById(R.id.ll_stats_league_nr));
        LinearLayout names = ((LinearLayout) findViewById(R.id.ll_stats_league_team));
        LinearLayout scoring = ((LinearLayout) findViewById(R.id.ll_stats_league_gsga));
        LinearLayout games = ((LinearLayout) findViewById(R.id.ll_stats_league_gp));
        LinearLayout points = ((LinearLayout) findViewById(R.id.ll_stats_league_points));

        for(Team team: sortedTeams) {
            // create text views
            TextView number = new TextView(this);
            TextView name = new TextView(this);
            TextView score = new TextView(this);
            TextView gp = new TextView(this);
            TextView point = new TextView(this);

            // set text
            number.setText(String.valueOf(rank));
            name.setText(nameShortener(team.getName()));
            score.setText(String.valueOf(team.getLeagueGoalsScored()) + ":" + String.valueOf(team.getLeagueGoalsAllowed()));
            gp.setText(String.valueOf(team.getLeagueGamesPlayed()));
            point.setText(String.valueOf(team.getLeaguePoints()));

            // apply Styling - can add stuff if needed
            number = applyStyling(number);
            name = applyStyling(name);
            score = applyStyling(score);
            gp = applyStyling(gp);
            point = applyStyling(point);

            // attach to layout
            numbers.addView(number);
            names.addView(name);
            scoring.addView(score);
            games.addView(gp);
            points.addView(point);

            rank++;
        }
    }

    private String nameShortener(String name) {
        if(name.length() > 15) {
            return name.substring(0, 16);
        }
        return name;
    }

    private TextView applyStyling(TextView textView) {
        textView.setTextSize(18);
        return textView;
    }

}
