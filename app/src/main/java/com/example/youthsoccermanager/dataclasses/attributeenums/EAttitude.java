package com.example.youthsoccermanager.dataclasses.attributeenums;

/**
 * Enum for the different attitudes a player can have, some players are motivated, some want to
 * become professionals, some think of soccer just as a leisure activity etc.
 * @author Philipp S.
 */
public enum EAttitude {
    MOTIVATED ("Motivated"),
    LEISURE ("Leisure");
    /*
     * ADD MORE HERE LATER ON
     * */

    String spelledOutAttitude;
    private EAttitude(String spelledOutAttitude) {
        this.spelledOutAttitude = spelledOutAttitude;
    }

    /**
     * getter method for attitude, will probably be deprecated in future versions because toString() and
     * some String manipulation should work as well
     * @return attitude as a regular case string
     */
    public String getSpelledOutAttitude() {
        return this.spelledOutAttitude;
    }
}
