package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jakobhaglof on 16/11/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "myDataBase";

    private SQLiteDatabase dbase;

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPlayer = "CREATE TABLE players (" +
         "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
         "name VARCHAR(255) NOT NULL," +
         "highscore INTEGER" +
         ")";

        sqLiteDatabase.execSQL(sqlPlayer);

        String sqlQuestions ="CREATE TABLE questions ("+

                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "question VARCHAR(255) NOT NULL," +
                "category VARCHAR(255) NOT NULL," +
                "choice1 VARCHAR(255) NOT NULL, " +
                "choice2 VARCHAR(255) NOT NULL, " +
                "choice3 VARCHAR(255) NOT NULL, " +
                "choice4 VARCHAR(255) NOT NULL, " +
                "correct VARCHAR(255) NOT NULL)";

        sqLiteDatabase.execSQL(sqlQuestions);

        dbase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}