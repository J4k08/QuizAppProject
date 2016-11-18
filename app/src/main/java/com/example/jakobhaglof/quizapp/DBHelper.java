package com.example.jakobhaglof.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jakobhaglof on 16/11/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "myDataBase";
    private SQLiteDatabase dbase;

    private static final String ID = "QuestionID";
    private static final String QUEST = "question";
    private static final String CATEGORY = "category";
    private static final String CORRECT = "correct";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";

    private static final String P_ID = "pId";
    private static final String P_NAME = "name";
    private static final String HIGHSCORE = "highscore";

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPlayer = "CREATE TABLE players (" +

         P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
         P_NAME + " VARCHAR(255) NOT NULL," +
         HIGHSCORE + " INTEGER" +
         ")";

        sqLiteDatabase.execSQL(sqlPlayer);

        String sqlQuestions ="CREATE TABLE questions ("+

                ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                QUEST +" VARCHAR(255) NOT NULL," +
                CATEGORY +" VARCHAR(255) NOT NULL," +
                CORRECT +" VARCHAR(255) NOT NULL," +
                CHOICE1 +" VARCHAR(255) NOT NULL, " +
                CHOICE2 +" VARCHAR(255) NOT NULL, " +
                CHOICE3 +" VARCHAR(255) NOT NULL, " +
                CHOICE4 +" VARCHAR(255) NOT NULL)";



        sqLiteDatabase.execSQL(sqlQuestions);
        addQuestion();


        dbase.close();
    }

    public void addQuestion() {

        Questions q1 = new Questions("What is 2 + 2?", "Math", "4", "1", "2", "4", "300");
        this.addQuestion(q1);

    }
    public void addQuestion(Questions quest) {

        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUEST, quest.getQuestion());
        values.put(CATEGORY, quest.getCategory());
        values.put(CORRECT, quest.getCorrectAnswer());
        values.put(CHOICE1, quest.getChoice1());
        values.put(CHOICE2, quest.getChoice2());
        values.put(CHOICE3, quest.getChoice3());
        values.put(CHOICE4, quest.getChoice4());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}