package com.example.youthsoccermanager.dataclasses.attributeenums;

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

    public String getSpelledOutAttitude() {
        return this.spelledOutAttitude;
    }
}
