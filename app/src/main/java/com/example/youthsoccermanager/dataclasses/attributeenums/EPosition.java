package com.example.youthsoccermanager.dataclasses.attributeenums;

/**
 * Enum that contains all the possible positions a player can have
 * @author Philipp S.
 */
public enum EPosition {
    GK ("Goalkeeper"),
    RB ("Right Back"),
    CB ("Centre Back"),
    LB ("Left Back"),
    DM ("Defensive Midfielder"),
    RM ("Right Midfielder"),
    CM ("Centre Midfielder"),
    LM ("Left Midfielder"),
    AM ("Attacking Midfielder"),
    RW ("Right Winger"),
    LW ("Left Winger"),
    ST ("Striker");

    String spelledOutPosition;
    private EPosition(String spelledOutPosition) {
        this.spelledOutPosition = spelledOutPosition;
    }

    /**
     * getter method that returns the position as a verbose string that contains the whole position name
     * instead of only the abbreviation that is used in the enum
     * @return full name of position
     */
    public String getSpelledOutPosition() {
        return this.spelledOutPosition;
    }
}
