package com.example.youthsoccermanager.dataclasses.player;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAttitude;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPosition;

import java.util.HashMap;

public class PlayerGeneralInfo {
    private String name, nationality;
    private int jerseyNr;
    private int salary, age, contractLength, skillClarity;
    private EPosition position;
    private EAgeGroup ageGroup;
    private EAttitude attitude;

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

    public String getAbbrevName() {
        String[] splitName = name.split("\\s+");
        return splitName[0].substring(0,1) + ". " + splitName[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public int getSkillClarity() {
        return skillClarity;
    }

    public void setSkillClarity(int skillClarity) {
        this.skillClarity = skillClarity;
    }

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;
    }

    public EAgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(EAgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public EAttitude getAttitude() {
        return attitude;
    }

    public void setAttitude(EAttitude attitude) {
        this.attitude = attitude;
    }

    public int getJerseyNr() {
        return jerseyNr;
    }

    public void setJerseyNr(int jerseyNr) {
        this.jerseyNr = jerseyNr;
    }
}
