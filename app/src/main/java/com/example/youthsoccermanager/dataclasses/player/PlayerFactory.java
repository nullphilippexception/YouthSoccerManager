package com.example.youthsoccermanager.dataclasses.player;

import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAttitude;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPosition;

public class PlayerFactory {
    public static PlayerFactory getPlayerFactory() {
        return new PlayerFactory();
    }

    // a player for testing purposes
    public Player getTestPlayer(int id, String name, int jerseyNr) {
        Player resultPlayer = new Player();
        PlayerGeneralInfo playerGeneralInfo = new PlayerGeneralInfo(name, EAgeGroup.U17, EPosition.DM, EAttitude.LEISURE,
                "Germany", 100, 16, 0, 100, jerseyNr);
        PlayerOnFieldAttributes onFieldAttributes = new PlayerOnFieldAttributes(50,51,52,53,
                54,55,56,57,58,59,60);
        PlayerThisSeasonStats thisSeasonStats = new PlayerThisSeasonStats(9,3,5,300,18,1500);
        resultPlayer.setTestPlayerAttributes(id, playerGeneralInfo, onFieldAttributes, thisSeasonStats);
        return resultPlayer;
    }
}
