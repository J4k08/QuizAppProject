package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class Game {

    private static final String TAG = "GAME";
    private int timer = 10000;
    private ArrayList<String> clickedCat;
    private Player player;
    private DBHelper db;
    private ArrayList<Question> questions;
    private Context context;

    /**
     * Constructor for Player object
     * @param context
     * @param timer
     * @param clickedCat
     * @param player
     */
    public Game(Context context, int timer, ArrayList<String> clickedCat, Player player) {
        this.timer = timer;
        this.clickedCat = clickedCat;
        this.player = player;
        this.context = context;
        db = new DBHelper(context);

    }

    /**
     * returns ArrayList of Question objects
     * @param questions
     * @return
     */
    public ArrayList<Question> getQuestions(ArrayList<Question> questions) {
        return questions;
    }
    /**
     * setter for Question variable, sets value to argument.
     * @param questions
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * returns Player object
     * @return
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * setter for Player variable, sets value to argument.
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * returns clickedCat variable
     * @return
     */
    public ArrayList<String> getClickedCat() {
        return clickedCat;
    }
    /**
     * setter for ArrayList clickedCat, sets value to argument.
     * @param clickedCat
     */
    public void setClickedCat(ArrayList<String> clickedCat) {
        this.clickedCat = clickedCat;
    }

    /**
     * returns timer variable
     * @return
     */
    public int getTimer() {
        return timer;
    }
    /**
     * setter for timer variable, sets value to argument.
     * @param timer
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }

    /**
     * Method for getting arrayList of Questions, shuffling it and returning.
     * @param clickedCat
     * @return
     */
    public ArrayList<Question> prepGame(ArrayList<String> clickedCat) {

            questions = getQuestionsFromDb(clickedCat);

            shuffleQuestions(questions);

            return questions;
    }
    /**
     * returns ArrayList with Question objects
     * @param clickedCat
     * @return
     */
    public ArrayList<Question> getQuestionsFromDb(ArrayList<String> clickedCat) {

        ArrayList<Question> questions;

            questions = db.getSpecificQuestions(clickedCat);

        return questions;
    }

    /**
     * Shuffles ArrayList and returns it.
     * @param questions
     */
    public void shuffleQuestions(ArrayList<Question> questions) {

        Collections.shuffle(questions);
    }

    /**
     * Shuffles ArrayList and returns it.
     * @param questions
     * @param round
     * @return
     */
    public ArrayList<String> shuffleAnswers(ArrayList<Question> questions, int round) {

        ArrayList<String> shuffledAnswers= new ArrayList<>();

            shuffledAnswers.add(questions.get(round).getChoice1());
            shuffledAnswers.add(questions.get(round).getChoice2());
            shuffledAnswers.add(questions.get(round).getChoice3());
            shuffledAnswers.add(questions.get(round).getChoice4());

        Collections.shuffle(shuffledAnswers);

        return shuffledAnswers;

    }

    /**
     * score variable returns timer / 1000 if the String guess is equal to the Question object's
     * correctAnswer. If there's no match it returns 0
     * @param guess
     * @param question
     * @param timer
     * @return
     */
    public int roundGuess(String guess, Question question, int timer) {

        int score;
        score = timer / 1000;

        if (guess.equals(question.getCorrectAnswer())) {
            return score;
        } else {
            return score = 0;
        }

    }
}