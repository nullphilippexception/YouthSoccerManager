package com.example.youthsoccermanager.dataclasses.player;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.attributeenums.EPosition;

import java.util.HashMap;

public class PlayerOnFieldAttributes {
    private int speed, strength, intelligence, defending, dribbling, passing, shooting, goalkeeping, exp, morale, fitness;

    public PlayerOnFieldAttributes(int speed, int strength, int intelligence, int defending,
                                   int dribbling, int passing, int shooting, int goalkeeping,
                                   int exp, int morale, int fitness) {
        this.speed = speed;
        this.strength = strength;
        this.intelligence = intelligence;
        this.defending = defending;
        this.dribbling = dribbling;
        this.passing = passing;
        this.shooting = shooting;
        this.goalkeeping = goalkeeping;
        this.exp = exp;
        this.morale = morale;
        this.fitness = fitness;
    }

    public HashMap<Integer,String> getPrintableData(EPosition position) {
        HashMap<Integer,String> result = new HashMap<>();
        result.put(R.id.player_display_speed, String.valueOf(speed));
        result.put(R.id.player_display_strength, String.valueOf(strength));
        result.put(R.id.player_display_intelligence, String.valueOf(intelligence));
        result.put(R.id.player_display_defending, String.valueOf(defending));
        result.put(R.id.player_display_dribbling, String.valueOf(dribbling));
        result.put(R.id.player_display_passing, String.valueOf(passing));
        result.put(R.id.player_display_shooting, String.valueOf(shooting));
        result.put(R.id.player_display_goalkeeping, String.valueOf(goalkeeping));
        result.put(R.id.player_display_morale, "Morale: " + String.valueOf(morale) + "%");
        result.put(R.id.player_display_fitness, "Fitness: " + String.valueOf(fitness) + "%");
        result.put(R.id.player_display_exp, "Exp: " + getExpStars());
        result.put(R.id.player_display_ovr, "OVR: " + computeOvrRating(position));
        return result;
    }

    private String getExpStars() {
        String result = "";
        int blackStars = exp / 10;
        int blackStarCode = 0x2605;
        int whiteStarCode = 0x2606;
        for(int i = 0; i < blackStars; i++) {
            result += new String(Character.toChars(blackStarCode));
        }
        if(exp % 10 >= 5) {
            result += new String(Character.toChars(whiteStarCode));
        }
        return result;
    }

    // THIS METHOD NEEDS TO BE IMPLEMENTED PROPERLY
    public int computeOvrRating(EPosition position) {
        /*
        * DUMMY RETURN
        * */
        return 60;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDefending() {
        return defending;
    }

    public void setDefending(int defending) {
        this.defending = defending;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getGoalkeeping() {
        return goalkeeping;
    }

    public void setGoalkeeping(int goalkeeping) {
        this.goalkeeping = goalkeeping;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
