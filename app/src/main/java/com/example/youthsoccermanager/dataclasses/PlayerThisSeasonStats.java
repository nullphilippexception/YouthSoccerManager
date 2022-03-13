package com.example.youthsoccermanager.dataclasses;

import com.example.youthsoccermanager.R;

import java.util.HashMap;

public class PlayerThisSeasonStats {
    private int assistsThisSeason, goalsThisSeason, gamesThisSeasonFriendly, minutesThisSeasonFriendly;
    private int gamesThisSeasonComp, minutesThisSeasonComp;

    public PlayerThisSeasonStats(int assists, int goals, int gamesF, int minutesF, int gamesC, int minutesC) {
        this.assistsThisSeason = assists;
        this.goalsThisSeason = goals;
        this.gamesThisSeasonFriendly = gamesF;
        this.minutesThisSeasonFriendly = minutesF;
        this.gamesThisSeasonComp = gamesC;
        this.minutesThisSeasonComp = minutesC;
    }

    public HashMap<Integer,String> getPrintableData() {
        HashMap<Integer,String> result = new HashMap<>();
        result.put(R.id.player_display_goals, String.valueOf(goalsThisSeason));
        result.put(R.id.player_display_assists, String.valueOf(assistsThisSeason));
        result.put(R.id.player_display_gamesF, String.valueOf(gamesThisSeasonFriendly));
        result.put(R.id.player_display_gamesC, String.valueOf(gamesThisSeasonComp));
        result.put(R.id.player_display_minutesF, String.valueOf(minutesThisSeasonFriendly));
        result.put(R.id.player_display_minutesC, String.valueOf(minutesThisSeasonComp));
        return result;
    }

    public int getAssistsThisSeason() {
        return assistsThisSeason;
    }

    public void setAssistsThisSeason(int assistsThisSeason) {
        this.assistsThisSeason = assistsThisSeason;
    }

    public int getGoalsThisSeason() {
        return goalsThisSeason;
    }

    public void setGoalsThisSeason(int goalsThisSeason) {
        this.goalsThisSeason = goalsThisSeason;
    }

    public int getGamesThisSeasonFriendly() {
        return gamesThisSeasonFriendly;
    }

    public void setGamesThisSeasonFriendly(int gamesThisSeasonFriendly) {
        this.gamesThisSeasonFriendly = gamesThisSeasonFriendly;
    }

    public int getMinutesThisSeasonFriendly() {
        return minutesThisSeasonFriendly;
    }

    public void setMinutesThisSeasonFriendly(int minutesThisSeasonFriendly) {
        this.minutesThisSeasonFriendly = minutesThisSeasonFriendly;
    }

    public int getGamesThisSeasonComp() {
        return gamesThisSeasonComp;
    }

    public void setGamesThisSeasonComp(int gamesThisSeasonComp) {
        this.gamesThisSeasonComp = gamesThisSeasonComp;
    }

    public int getMinutesThisSeasonComp() {
        return minutesThisSeasonComp;
    }

    public void setMinutesThisSeasonComp(int minutesThisSeasonComp) {
        this.minutesThisSeasonComp = minutesThisSeasonComp;
    }
}
