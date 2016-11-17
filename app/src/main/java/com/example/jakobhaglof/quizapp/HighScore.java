package com.example.jakobhaglof.quizapp;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by jakobhaglof on 17/11/16.
 */

public class HighScore {

    private int[] totHighScore = new int[10];

    private int[] categoryHighScore = new int[10];

    public HighScore(int[] categoryHighScore, int[] totHighScore) {
        this.categoryHighScore = categoryHighScore;
        this.totHighScore = totHighScore;
    }


    public int[] getTotHighScore() {
        return totHighScore;
    }
    public void setTotHighScore(int[] totHighScore) {
        this.totHighScore = totHighScore;
    }

    public int[] getCategoryHighScore() {
        return categoryHighScore;
    }
    public void setCategoryHighScore(int[] categoryHighScore) {
        this.categoryHighScore = categoryHighScore;
    }

    public void showHighScore(){

    }


}
