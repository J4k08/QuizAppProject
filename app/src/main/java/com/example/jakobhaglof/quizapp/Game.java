package com.example.jakobhaglof.quizapp;

import java.util.ArrayList;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Game {

    private int timer = 0;
    private int gameScore = 0;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private Player player;

    public Game(int timer, int gameScore, ArrayList<Question> questions, Player player) {
        this.timer = timer;
        this.gameScore = gameScore;
        this.questions = questions;
        this.player = player;
    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getGameScore() {
        return gameScore;
    }
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void startGame(Player player, ArrayList<Question> questions) {


    }

    public void timeOut(int timer) {


    }

}

