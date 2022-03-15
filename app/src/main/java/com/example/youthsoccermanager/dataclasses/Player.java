package com.example.youthsoccermanager.dataclasses;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPreviewValues;

import java.util.HashMap;

/**
 * The player is a very important data class, they are the key to the game. A player has lots of attributes that are stored
 * in objects plus an id that uniquely identifies the player object. Descriptions for different interaction possibilities of
 * a player will be added here later on.
 * @author Philipp S.
 */
public class Player {
    /**
     * unique identifier of the player object
     */
    private int id;
    /**
     * contains: name, nationality, jerseynr, salary, age, length of contract, clarity of skill (only important for players
     * on non-user teams), position, agegroup and attitude
     */
    private PlayerGeneralInfo generalInfo;
    /**
     * contains: speed, strength, intelligence, defending, dribbling, passing, shooting ,goalkeeping, experience,
     * morale, fitness
     */
    private PlayerOnFieldAttributes onFieldAttributes;
    /**
     * contains: goals and assists this season, as well as games and minutes played this seasons divided in
     * categories competitive and friendly games
     */
    private PlayerThisSeasonStats thisSeasonStats;

    /**
     * ctor used for testing purposes
     */
    public Player() {
    }

    /**
     * testing method to create simple dummy player objects that can be displayed on newly created screens
     * @param id id of dummy player
     * @param playerGeneralInfo general info of dummy player
     * @param playerOnFieldAttributes on field attributes of dummy player
     * @param playerThisSeasonStats stats of dummy player
     */
    public void setTestPlayerAttributes(int id, PlayerGeneralInfo playerGeneralInfo, PlayerOnFieldAttributes playerOnFieldAttributes,
                                        PlayerThisSeasonStats playerThisSeasonStats) {
        this.id = id;
        this.generalInfo = playerGeneralInfo;
        this.onFieldAttributes = playerOnFieldAttributes;
        this.thisSeasonStats = playerThisSeasonStats;
    }

    /**
     * getter method for unique id of player object
     * @return id of this player object
     */
    public int getId() {
        return this.id;
    }

    /**
     * method that puts all the player data that is needed for a preview screen into a hashmap
     * @return a hashmap that identifies all the values retrieved from the player object using the EPreviewValues enum
     */
    public HashMap<EPreviewValues, String> getPlayerPrintablePreview() {
        HashMap<EPreviewValues, String> result = new HashMap<>();
        int ovrRating = onFieldAttributes.computeOvrRating(generalInfo.getPosition());
        result.put(EPreviewValues.OVERALL, String.valueOf(ovrRating));
        result.put(EPreviewValues.AGE, String.valueOf(generalInfo.getAge()));
        result.put(EPreviewValues.POSITION, generalInfo.getPosition().toString());
        result.put(EPreviewValues.NAME, generalInfo.getAbbrevName());
        return result;
    }

    /**
     * method that puts all the player data into a hashmap so that the caller can easily retrieve it (by using id
     * of the corresponding UI object) and print the data to the screen
     * @return a hashmap that contains all player data and identifies each piece of that with corresponding UI object id
     */
    public HashMap<Integer, String> getPlayerPrintableData() {
        HashMap<Integer, String> result = new HashMap<>();
        result.putAll(generalInfo.getPrintableData());
        result.putAll(onFieldAttributes.getPrintableData(generalInfo.getPosition()));
        result.putAll(thisSeasonStats.getPrintableData());
        return result;
    }
}
