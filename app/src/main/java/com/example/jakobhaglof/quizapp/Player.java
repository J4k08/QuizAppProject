package com.example.jakobhaglof.quizapp;

import android.content.Context;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Player {

    private String name;
    private int highScore;
    private int monkeyID;

    /**
     * Constructor for Player class, creates an object and sets name, highScore and monkeyId to
     * default values
     */
    public Player() {
        name = "";
        highScore = 0;
        monkeyID = 0;
    }
    /**
     * Constructor for Player class, creates an object and sets name, highScore and monkeyId to
     * the values in the argument.
     * @param monkeyID
     * @param name
     * @param highScore
     */
    public Player(int monkeyID, String name, int highScore) {
        this.monkeyID = monkeyID;
        this.name = name;
        this.highScore = highScore;
    }

    /**
     * returns name variable of Player objects
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * setter for name variable, sets value to argument.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns highScore variable of Player objects.
     * @return
     */
    public int getHighScore() {
        return highScore;
    }
    /**
     * setter for highScore variable, sets value to argument.
     * @param highScore
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * returns monkeyId variable of Player objects
     * @return
     */
    public int getMonkeyID() {
        return monkeyID;
    }
    /**
     * setter for monkeyId variable, sets value to argument.
     * @param monkeyID
     */
    public void setMonkeyID(int monkeyID) {
        this.monkeyID = monkeyID;
    }

    @Override
    public String toString() {
        return name;
    }
}
