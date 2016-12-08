package com.example.jakobhaglof.quizapp;

import android.content.Context;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Player {

    private String name;
    private int highScore;
    private int monkeyID;


    public Player() {
        name = "";
        highScore = 0;
        monkeyID = 0;
    }

    public Player(int monkeyID, String name, int highScore) {
        this.monkeyID = monkeyID;
        this.name = name;
        this.highScore = highScore;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHighScore() {
        return highScore;
    }
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getMonkeyID() {
        return monkeyID;
    }
    public void setMonkeyID(int monkeyID) {
        this.monkeyID = monkeyID;
    }

    @Override
    public String toString() {
        return name;
    }
}
