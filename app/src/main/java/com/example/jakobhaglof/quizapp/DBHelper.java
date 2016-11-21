package com.example.jakobhaglof.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.id;
import static android.content.ContentValues.TAG;

/**
 * Created by jakobhaglof on 16/11/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "myDataBase";
    private SQLiteDatabase dbase;

    private static final String QUEST_TABLE = "questions";
    private static final String ID = "questionID";
    private static final String QUEST = "question";
    private static final String CATEGORY = "category";
    private static final String CORRECT = "correct";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";

    private static final String P_TABLE = "players";
    private static final String P_ID = "pId";
    private static final String P_NAME = "name";
    private static final String P_HIGHSCORE = "highscore";

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPlayer = "CREATE TABLE" + P_TABLE + "(" +

         P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
         P_NAME + " VARCHAR(255) NOT NULL," +
         P_HIGHSCORE + " INTEGER" + ")";

        sqLiteDatabase.execSQL(sqlPlayer);


        String sqlQuestions ="CREATE TABLE" + QUEST_TABLE + "("+

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
    }

    public void addQuestion() {

        Questions q1 = new Questions("What is 2 + 2?", "Math", "4", "1", "2", "4", "300");
        this.addQuestion(q1);
        Log.d("lagt till question", "row id " + id);

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

        dbase.insert(QUEST_TABLE, null, values);
        dbase.close();

    }

    public void addPlayer(Player player) {

        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(P_NAME, player.getName());
        values.put(P_HIGHSCORE, player.getHighScore());

        dbase.insert(P_TABLE, null, values);
        dbase.close();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}