package com.example.jakobhaglof.quizapp;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Player {

    private int currentScore;
    private String name;
    private int highScore;

    public Player() {

        currentScore = 0;
        name = "";
        highScore = 0;

    }

    public Player(int currentScore, String name, int highScore) {
        this.currentScore = currentScore;
        this.name = name;
        this.highScore = highScore;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
