package com.example.jakobhaglof.quizapp;

/**
 * Created by Curject on 17/11/16.
 */

public class Questions {

    private String category;

    private String question;

    private String correctAnswer;

    private String wrongAnswer1;

    private String wrongAnswer2;

    private String wrongAnswer3;

    public Questions(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }
    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }
    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }
    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public Questions addQuestion(Questions questions) {

        return questions;
        //Överflödig metod?
    }

    public void removeQuestion(){
        //ctrl+alt+del
    }

    public void shuffleQuestion(){
        //Blanda ordningen som svars alternativen kommer fram i spelet
    }
}
