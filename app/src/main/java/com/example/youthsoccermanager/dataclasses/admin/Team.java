package com.example.youthsoccermanager.dataclasses.admin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="league")
    String league; // enum would be better?

    @ColumnInfo(name="leagueGamesPlayed")
    int leagueGamesPlayed;

    @ColumnInfo(name="leagueGoalsScored")
    int leagueGoalsScored;

    @ColumnInfo(name="leagueGoalsAllowed")
    int leagueGoalsAllowed;

    @ColumnInfo(name="leaguePoints")
    int leaguePoints;

    public Team(String name, String league, int leagueGamesPlayed, int leagueGoalsScored, int leagueGoalsAllowed,
                int leaguePoints) {
        this.name = name;
        this.league = league;
        this.leagueGamesPlayed = leagueGamesPlayed;
        this.leagueGoalsScored = leagueGoalsScored;
        this.leagueGoalsAllowed = leagueGoalsAllowed;
        this.leaguePoints = leaguePoints;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public int getLeagueGamesPlayed() {
        return leagueGamesPlayed;
    }

    public int getLeagueGoalsScored() {
        return leagueGoalsScored;
    }

    public int getLeagueGoalsAllowed() {
        return leagueGoalsAllowed;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public String getAbbrevName() { // to make displaying team names easier
        if(name.length() > 15) {
            return name.substring(0, 16);
        }
        return name;
    }
}
