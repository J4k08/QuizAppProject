package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.widget.Switch;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Game {

    private int timer = 0;
    private int gameScore = 0;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private Player player;
    private DBHelper db;
    private Context context;

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

    public void prepGame(ArrayList<Question> questions, ArrayList<String> clicked) {

        db = new DBHelper(context);

        questions = getQuestionsFromDb(clicked);

        shuffleQuestions(questions);

    }

    public void playRound(Player player, ArrayList<Question> questions) {


    }

    public ArrayList<Question> getQuestionsFromDb(ArrayList<String> clicked) {

        List<Question> questionsList;
        ArrayList<Question> questions = new ArrayList<>();

            questionsList = db.getSpecificQuestions(clicked);
            questions = ListToArrayList(questionsList, questions);

        return questions;
    }
    public void shuffleQuestions(ArrayList<Question> questions) {

        Collections.shuffle(questions);
    }

    public ArrayList<Question> ListToArrayList (List<Question> questionList, ArrayList<Question> questions) {


        for(int i = 0; i < questionList.size(); i++){

            questions.add(questionList.get(i));
        }
        return questions;

    }


}

