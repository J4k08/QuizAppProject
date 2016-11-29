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
    private ArrayList<String> clickedCat;
    private Player player;
    private DBHelper db;
    private Context context;
    private ArrayList<Question> questions;

    public Game(int timer, ArrayList<String> clickedCat, Player player) {
        this.timer = timer;
        this.clickedCat = clickedCat;
        this.player = player;

    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public ArrayList<Question> getQuestions(ArrayList<Question> questions) {
        return questions;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<String> getClickedCat() {
        return clickedCat;
    }
    public void setClickedCat(ArrayList<String> clickedCat) {
        this.clickedCat = clickedCat;
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

    public ArrayList<Question> prepGame(ArrayList<String> clickedCat) {

        db = new DBHelper(context);

        questions = getQuestionsFromDb(clickedCat);

        shuffleQuestions(questions);

        return questions;

    }

    public void playRound(Player player, ArrayList<Question> questions) {

    }

    public ArrayList<Question> getQuestionsFromDb(ArrayList<String> clickedCat) {

        List<Question> questionsList;
        ArrayList<Question> questions = new ArrayList<>();

            questionsList = db.getSpecificQuestions(clickedCat);
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

    public void roundGuess(String guess, Question question, Player player) {

        int score = 10;

        if(guess.equals(question.getCorrectAnswer())) {

            player.setCurrentScore(score += player.getCurrentScore());

        }

    }

}