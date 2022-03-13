package com.example.youthsoccermanager.dataclasses;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPreviewValues;

import java.util.HashMap;

public class Player {
    private int id;
    private PlayerGeneralInfo generalInfo;
    private PlayerOnFieldAttributes onFieldAttributes;
    private PlayerThisSeasonStats thisSeasonStats;

    // insecure empty default constructor
    public Player() {
    }

    // method used for creating test players
    public void setTestPlayerAttributes(int id, PlayerGeneralInfo playerGeneralInfo, PlayerOnFieldAttributes playerOnFieldAttributes,
                                        PlayerThisSeasonStats playerThisSeasonStats) {
        this.id = id;
        this.generalInfo = playerGeneralInfo;
        this.onFieldAttributes = playerOnFieldAttributes;
        this.thisSeasonStats = playerThisSeasonStats;
    }

    public int getId() {
        return this.id;
    }

    // for squad list
    public HashMap<EPreviewValues, String> getPlayerPrintablePreview() {
        HashMap<EPreviewValues, String> result = new HashMap<>();
        int ovrRating = onFieldAttributes.computeOvrRating(generalInfo.getPosition());
        result.put(EPreviewValues.OVERALL, String.valueOf(ovrRating));
        result.put(EPreviewValues.AGE, String.valueOf(generalInfo.getAge()));
        result.put(EPreviewValues.POSITION, generalInfo.getPosition().toString());
        result.put(EPreviewValues.NAME, generalInfo.getAbbrevName());
        return result;
    }

    // method to enable player to be printed to screen
    public HashMap<Integer, String> getPlayerPrintableData() {
        HashMap<Integer, String> result = new HashMap<>();
        result.putAll(generalInfo.getPrintableData());
        result.putAll(onFieldAttributes.getPrintableData(generalInfo.getPosition()));
        result.putAll(thisSeasonStats.getPrintableData());
        return result;
    }
}
