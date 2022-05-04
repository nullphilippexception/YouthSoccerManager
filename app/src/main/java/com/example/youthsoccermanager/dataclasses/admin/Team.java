package com.example.youthsoccermanager.dataclasses.admin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.youthsoccermanager.dataclasses.attributeenums.ELeague;

import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
public class Team {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="league")
    String league; // enum would be better?

    @ColumnInfo(name="ageGroup")
    String ageGroup;

    @ColumnInfo(name="leagueGamesPlayed")
    int leagueGamesPlayed;

    @ColumnInfo(name="leagueGoalsScored")
    int leagueGoalsScored;

    @ColumnInfo(name="leagueGoalsAllowed")
    int leagueGoalsAllowed;

    @ColumnInfo(name="leaguePoints")
    int leaguePoints;

    public Team(String name, String league, String ageGroup, int leagueGamesPlayed, int leagueGoalsScored, int leagueGoalsAllowed,
                int leaguePoints) {
        this.name = name;
        Logger.getAnonymousLogger().log(Level.INFO, "Created team with name: " + name);
        this.ageGroup = ageGroup;
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

    public String getAgeGroup() {
        return ageGroup;
    }

    public ELeague getLeagueEnumType() throws IllegalArgumentException {
        return ELeague.getLeagueEnumType(this.league);
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
