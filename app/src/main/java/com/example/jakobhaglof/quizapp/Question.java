package com.example.jakobhaglof.quizapp;

import android.content.Context;

/**
 * Created by Curject on 17/11/16.
 */

public class Question {

    private String category;
    private String question;
    private String correctAnswer;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    public Question() {
        category = "";
        question = "";
        correctAnswer = "";
        choice1 = "";
        choice2 = "";
        choice3 = "";
        choice4 = "";
    }

    public Question(String question, String category, String correctAnswer, String choice1, String choice2, String choice3, String choice4) {

        this.question = question;
        this.category = category;
        this.correctAnswer = correctAnswer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;

    }

    /**
     * returns category variable of Question objects
     * @return
     */
    public String getCategory() {
        return category;
    }
    /**
     * setter for category variable, sets value to argument.
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * * returns question variable of Question objects
     * @return
     */
    public String getQuestion() {
        return question;
    }
    /**
     * setter for question variable, sets value to argument.
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * * returns correctAnswer variable of Question objects
     * @return
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * setter for correctAnswer variable, sets value to argument.
     * @param correctAnswer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * * returns choice1 variable of Question objects
     * @return
     */
    public String getChoice1() {
        return choice1;
    }
    /**
     * setter for choice1 variable, sets value to argument.
     * @param choice1
     */
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    /**
     * * returns choice2 variable of Question objects
     * @return
     */
    public String getChoice2() {
        return choice2;
    }
    /**
     * setter for choice2 variable, sets value to argument.
     * @param choice2
     */
    public void setChoice2(String choice2) {
        this.choice2= choice2;
    }

    /**
     * * returns choice3 variable of Question objects
     * @return
     */
    public String getChoice3() {
        return choice3;
    }
    /**
     * setter for choice3 variable, sets value to argument.
     * @param choice3
     */
    public void setChoice3(String choice3) {
        this.choice3= choice3;
    }

    /**
     * * returns choice4 variable of Question objects
     * @return
     */
    public String getChoice4() {
        return choice4;
    }
    /**
     * setter for choice4 variable, sets value to argument.
     * @param choice4
     */
    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

}
