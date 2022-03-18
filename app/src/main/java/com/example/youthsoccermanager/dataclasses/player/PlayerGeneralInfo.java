package com.example.youthsoccermanager.dataclasses.player;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAttitude;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPosition;

import java.util.HashMap;

/**
 * data class that is usually only used in conjunction with a Player object, as a PlayerGeneralInfo object is
 * one of the fields of a Player object; it contains general info on the player like name, age, nationality of
 * financial info
 * @author Philipp S.
 */
public class PlayerGeneralInfo {
    private String name, nationality;
    private int jerseyNr;
    private int salary, age, contractLength, skillClarity;
    private EPosition position;
    private EAgeGroup ageGroup;
    private EAttitude attitude;

    /**
     * ctor of PlayerGeneralInfo where all its fields are set
     * @param name name of the player the object will be associated with
     * @param ageGroup ageGroup of the player the object will be associated with, ie U13, U15, U17 or U19
     * @param position position of the player the object will be associated with
     * @param attitude attitude of the player the object will be associated with
     * @param nationality nationality of the player the object will be associated with
     * @param salary salary of the player the object will be associated with
     * @param age age of the player the object will be associated with
     * @param contractLength remaining length of the contract of the player the object will be associated with
     * @param skillClarity only used for players not on users team: low skill clarity blurs the true skill values of a player
     *                     when the user is looking at the player, this can be solved by further scouting the player
     * @param jerseyNr jersey number of the player the object will be associated with
     */
    public PlayerGeneralInfo(String name, EAgeGroup ageGroup, EPosition position, EAttitude attitude, String nationality,
                             int salary, int age, int contractLength, int skillClarity, int jerseyNr) {
        this.name = name;
        this.nationality = nationality;
        this.salary = salary;
        this.age = age;
        this.contractLength = contractLength;
        this.skillClarity = skillClarity;
        this.position = position;
        this.ageGroup = ageGroup;
        this.attitude = attitude;
        this.jerseyNr = jerseyNr;
    }

    /**
     * method that puts all the data of this object into a hashmap that can easily be used by the caller to
     * put the data on the screen
     * @return hashmap that has resource ids of screen elements as keys and the generalInfo data as values
     */
    public HashMap<Integer,String> getPrintableData() {
        HashMap<Integer,String> result = new HashMap<>();
        result.put(R.id.player_display_namenr, name + "(#" + String.valueOf(jerseyNr) + ")");
        result.put(R.id.player_display_nationality, nationality);
        result.put(R.id.player_display_agesalarycontract, "Age: " + String.valueOf(age) +
                ", Salary: €" + String.valueOf(salary) + ", Rem. Contract: " + String.valueOf(contractLength));
        result.put(R.id.player_display_position, position.getSpelledOutPosition());
        result.put(R.id.player_display_attitude, "Attitude: " + attitude.getSpelledOutAttitude());
        return result;
    }

    /**
     * method to return the abbreviated version of the name field by only using first letter
     * of first name and then putting a dot, mostly used for UI purposes
     * @return abbreviated version of name, e.g.: "Test Testplayer" becomes "T. Testplayer"
     */
    public String getAbbrevName() {
        String[] splitName = name.split("\\s+");
        return splitName[0].substring(0,1) + ". " + splitName[1];
    }

    /**
     * getter for name field
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name field
     * @param name new value for name field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for nationality field
     * @return nationality field
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * setter for nationality field
     * @param nationality new value for nationality field
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * getter for salary field
     * @return salary field
     */
    public int getSalary() {
        return salary;
    }

    /**
     * setter for salary field
     * @param salary new value for salary field
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * getter for age field
     * @return age field
     */
    public int getAge() {
        return age;
    }

    /**
     * setter for age field
     * @param age new value for age field
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * getter for contract length field
     * @return contract length field
     */
    public int getContractLength() {
        return contractLength;
    }

    /**
     * setter for contract length field
     * @param contractLength new value for contract length field
     */
    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    /**
     * getter for skill clarity field
     * @return skill clarity field
     */
    public int getSkillClarity() {
        return skillClarity;
    }

    /**
     * setter for skill clarity field
     * @param skillClarity new value for skill clarity field
     */
    public void setSkillClarity(int skillClarity) {
        this.skillClarity = skillClarity;
    }

    /**
     * getter for position field
     * @return position field
     */
    public EPosition getPosition() {
        return position;
    }

    /**
     * setter for position field
     * @param position new value for position field
     */
    public void setPosition(EPosition position) {
        this.position = position;
    }

    /**
     * getter for age group field
     * @return age group field
     */
    public EAgeGroup getAgeGroup() {
        return ageGroup;
    }

    /**
     * setter for age group field
     * @param ageGroup new value for age group field
     */
    public void setAgeGroup(EAgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**
     * getter for attitude field
     * @return age group field
     */
    public EAttitude getAttitude() {
        return attitude;
    }

    /**
     * setter for age group field
     * @param attitude new value for age group field
     */
    public void setAttitude(EAttitude attitude) {
        this.attitude = attitude;
    }

    /**
     * getter for age group field
     * @return age group field
     */
    public int getJerseyNr() {
        return jerseyNr;
    }

    /**
     * setter for age group field
     * @param jerseyNr new value for age group field
     */
    public void setJerseyNr(int jerseyNr) {
        this.jerseyNr = jerseyNr;
    }
}
