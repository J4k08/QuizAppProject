package com.example.jakobhaglof.quizapp;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Player {

    private int currentScore;

    private String Name;

    private int highScore;


    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public int getCurrentScore() {
        return currentScore;
    }
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getHighScore() {
        return highScore;
    }
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }


    public void sendScore(int currentScore) {

        //episk kod här

    }

}
