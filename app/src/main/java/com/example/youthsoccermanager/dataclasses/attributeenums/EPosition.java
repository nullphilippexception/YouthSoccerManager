package com.example.youthsoccermanager.dataclasses.attributeenums;

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

    public String getSpelledOutPosition() {
        return this.spelledOutPosition;
    }
}
