package com.example.jakobhaglof.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jakobhaglof on 16/11/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "Databas: ";
    private static final String db_name = "myDataBase";
    private SQLiteDatabase db;
    public Context context;


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
    private static final String P_MONKEY = "monkey";

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPlayer = "CREATE TABLE IF NOT EXISTS " + P_TABLE + "(" +

         P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
         P_NAME + " VARCHAR(255) NOT NULL," +
         P_MONKEY + " INTEGER," +
         P_HIGHSCORE + " INTEGER)";

        sqLiteDatabase.execSQL(sqlPlayer);

        String sqlQuestions ="CREATE TABLE " + QUEST_TABLE + "("+

                ID +"_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                QUEST +" VARCHAR(255) NOT NULL," +
                CATEGORY +" VARCHAR(255) NOT NULL," +
                CORRECT +" VARCHAR(255) NOT NULL, " +
                CHOICE1 +" VARCHAR(255) NOT NULL, " +
                CHOICE2 +" VARCHAR(255) NOT NULL, " +
                CHOICE3 +" VARCHAR(255) NOT NULL, " +
                CHOICE4 +" VARCHAR(255) NOT NULL)";

        sqLiteDatabase.execSQL(sqlQuestions);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addQuestion() {

        //Film & TV
        //Historia
        //Musik
        //Diverse

        Question q1T = new Question("Vem spelade Harry Potter i filmen Harry Potter?"
                , "TV", "Daniel Radcliffe", "Marlon Brando", "Daniel Radcliffe", "Sven Wolter", "Han ljudkillen från polisskolan");
        this.addQuestion(q1T);

        Question q1M = new Question("Vem är inte en medlem i ABBA?", "Musik", "Babben Larsson", "Björn Ulvaeus", "Anni-Frid Lyngstad",
                "Babben Larsson", "Agnetha Fältskog");
        this.addQuestion(q1M);

        Question q1H = new Question("När föll Berlinmuren?", "Historia", "1989", "1986", "1992", "1989", "1995");

        this.addQuestion(q1H);

        Question q1D = new Question("Vad står MSN för?", "Diverse", "Microsoft Network", "Microsoft Network", "Mass Sending Network",
                "Multimedia Server Name", "Microsoft Social Network");
        this.addQuestion(q1D);


    }
    public void addQuestion(Question quest) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(QUEST, quest.getQuestion());
        values.put(CATEGORY, quest.getCategory());
        values.put(CORRECT, quest.getCorrectAnswer());
        values.put(CHOICE1, quest.getChoice1());
        values.put(CHOICE2, quest.getChoice2());
        values.put(CHOICE3, quest.getChoice3());
        values.put(CHOICE4, quest.getChoice4());

        long id = db.insert(QUEST_TABLE, null, values);
        Log.d("lagt till question", "row id " + id);
        db.close();
    }
    public void addPlayer(Player player) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(P_NAME, player.getName());
        values.put(P_HIGHSCORE, player.getHighScore());
        values.put(P_MONKEY, player.getMonkeyID());

        long id = db.insert(P_TABLE, null, values);
        Log.d("lagt till player", "row id " + P_ID);
        db.close();
    }

    public List<Question> getAllQuestions() {

        List<Question> questionList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + QUEST_TABLE;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Question quest = new Question();

                quest.setQuestion(cursor.getString(cursor.getColumnIndex(QUEST)));
                quest.setCategory(cursor.getString(cursor.getColumnIndex(CATEGORY)));
                quest.setCorrectAnswer(cursor.getString(cursor.getColumnIndex(CORRECT)));
                quest.setChoice1(cursor.getString(cursor.getColumnIndex(CHOICE1)));
                quest.setChoice2(cursor.getString(cursor.getColumnIndex(CHOICE2)));
                quest.setChoice3(cursor.getString(cursor.getColumnIndex(CHOICE3)));
                quest.setChoice4(cursor.getString(cursor.getColumnIndex(CHOICE4)));

                questionList.add(quest);
            } while (cursor.moveToNext());

        }
        cursor.close();

        Log.d(TAG,"questionList skapad!");

        return questionList;


    }

    public ArrayList<Question> getSpecificQuestions(ArrayList<String> categories) {


        Log.d(TAG, "getSpecificQuestions: " + categories.get(0));

        String choices = CATEGORY+"=?";

        ArrayList<Question> questionList = new ArrayList<Question>();


        if(categories.size() > 1) {
            Log.d(TAG, "getSpecificQuestions: GÅR IN I FORLOOPEN");

            for(int i = 1; i < categories.size(); i++) {

                choices +=" OR " + CATEGORY+"=?";
                Log.d(TAG, "getSpecificQuestions: " + categories.get(i));
            }

        }

        //String selectQuery = "SELECT * FROM " + QUEST_TABLE + " WHERE " + CATEGORY + "=\""+ choices +"\"";

        db = this.getReadableDatabase();


        String[] categoriesArray = categories.toArray(new String[categories.size()]);

        Cursor cursor = db.query(true, QUEST_TABLE, null, choices, categoriesArray, null, null, null, null);


        //Cursor cursor = db.rawQuery(selectQuery, null);

        Log.d(TAG, "getSpecificQuestions: Innan If-sats");

        if (cursor.moveToFirst()) {
            do {

                Log.d(TAG, "getSpecificQuestions: Efter if-sats");
                Question quest = new Question();

                quest.setQuestion(cursor.getString(cursor.getColumnIndex((QUEST))));
                quest.setCategory(cursor.getString(cursor.getColumnIndex((CATEGORY))));
                quest.setCorrectAnswer(cursor.getString(cursor.getColumnIndex((CORRECT))));
                quest.setChoice1(cursor.getString(cursor.getColumnIndex((CHOICE1))));
                quest.setChoice2(cursor.getString(cursor.getColumnIndex((CHOICE2))));
                quest.setChoice3(cursor.getString(cursor.getColumnIndex((CHOICE3))));
                quest.setChoice4(cursor.getString(cursor.getColumnIndex((CHOICE4))));


                Log.d(TAG, "getSpecificQuestions: " + quest.getQuestion());

                questionList.add(quest);

            } while (cursor.moveToNext());

        }
        cursor.close();

        db.close();

        Log.d(TAG, "getSpecificQuestions: Kommer till slutet");
        return questionList;

    }

    public Player getPlayerFromDB(String name) {

        String selectQuery = "SELECT * FROM " + P_TABLE + " WHERE " + P_NAME + "=\""+ name +"\"";

        db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        Player player = new Player();

        if(cursor.moveToFirst()) {
            player.setName(cursor.getString(cursor.getColumnIndex(P_NAME)));
            player.setHighScore(cursor.getInt(cursor.getColumnIndex(P_HIGHSCORE)));
            player.setMonkeyID(cursor.getInt(cursor.getColumnIndex(P_MONKEY)));
        } else {
            player = null;
        }

        cursor.close();
        Log.d(TAG, player.getName() + " " + player.getHighScore());

        db.close();

        return player;

    }

    public List<Player> getAllPlayers() {


        List<Player> playerList = new ArrayList<Player>();

            String selectQuery = "SELECT * FROM " + P_TABLE;
            db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    Player p = new Player();

                    p.setName(cursor.getString(cursor.getColumnIndex(P_NAME)));
                    p.setHighScore(cursor.getInt(cursor.getColumnIndex(P_HIGHSCORE)));
                    p.setMonkeyID(cursor.getInt(cursor.getColumnIndex(P_MONKEY)));


                    playerList.add(p);
                } while (cursor.moveToNext());

            }
            cursor.close();
            db.close();

            Log.d(TAG, "PlayerList skapad!");

        return playerList;
    }

}