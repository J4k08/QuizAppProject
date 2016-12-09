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

    public Game(Context context, int timer, ArrayList<String> clickedCat, Player player) {
        this.timer = timer;
        this.clickedCat = clickedCat;
        this.player = player;
        this.context = context;
        db = new DBHelper(context);

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

    public ArrayList<Question> prepGame(ArrayList<String> clickedCat) {

            questions = getQuestionsFromDb(clickedCat);

            shuffleQuestions(questions);

            return questions;
    }

    public ArrayList<Question> getQuestionsFromDb(ArrayList<String> clickedCat) {

        ArrayList<Question> questions;

            questions = db.getSpecificQuestions(clickedCat);

        return questions;
    }
    public void shuffleQuestions(ArrayList<Question> questions) {

        Collections.shuffle(questions);
    }

    public ArrayList<String> shuffleAnswers(ArrayList<Question> questions, int round) {

        ArrayList<String> shuffledAnswers= new ArrayList<>();

            shuffledAnswers.add(questions.get(round).getChoice1());
            shuffledAnswers.add(questions.get(round).getChoice2());
            shuffledAnswers.add(questions.get(round).getChoice3());
            shuffledAnswers.add(questions.get(round).getChoice4());

        Collections.shuffle(shuffledAnswers);

        return shuffledAnswers;

    }

    public int roundGuess(String guess, Question question, int timer) {

        Log.d(TAG, "roundGuess: Klickade är: " + guess);

        Log.d(TAG, "roundGuess: Rätt svar i metod: " + question.getCorrectAnswer());
        int score;
        score = timer / 1000;

        if (guess.equals(question.getCorrectAnswer())) {
            Log.d(TAG, "roundGuess: Poäng efter rätt svar: " + score);
            return score;
        } else {
            return score = 0;
        }

    }
}