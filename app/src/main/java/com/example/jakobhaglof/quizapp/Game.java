package com.example.jakobhaglof.quizapp;

import java.util.ArrayList;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Game {

    int timer = 0;
    int correctAnswer = 0;
    int gameScore = 0;
    private ArrayList<Questions> questions = new ArrayList<Questions>;
    private Player player;

    public Game(int timer, int correctAnswer, int gameScore, ArrayList<Questions> questions, Player player) {
        this.timer = timer;
        this.correctAnswer = correctAnswer;
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

    public ArrayList<Questions> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }

    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getGameScore() {
        return gameScore;
    }
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void startGame(Player player, ArrayList<Questions> questions) {

        //tar emot ett player-objekt och en ArrayList av Questions-objekt och spelar igenom spelet!
    }

    public void timeOut(int timer) {


    }

}

