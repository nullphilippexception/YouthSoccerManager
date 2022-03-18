package com.example.youthsoccermanager.dataclasses.player;

import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAttitude;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPosition;

/**
 * PlayerFactory is part of a factory pattern that creates new players. Since players have many fields it would be
 * too cumbersome to create them with a regular ctor
 * @author Philipp S.
 */
public class PlayerFactory {

    /**
     * Static method that creates a new player factory
     * @return a PlayerFactory that can be used to create players
     */
    public static PlayerFactory getPlayerFactory() {
        return new PlayerFactory();
    }

    /**
     * Method that returns a player specifically created for testing purposes. The player has lots of default-set
     * fields, only the id, name and jerseynr can be specifically chosen by the caller
     * @param id unique player id of the player to be created
     * @param name name of the player to be created
     * @param jerseyNr (within team unique) jerseynr of the player to be created
     * @return a player object with id = id, name = name, jerseynr = jerseynr and all other attributes default-set
     */
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
