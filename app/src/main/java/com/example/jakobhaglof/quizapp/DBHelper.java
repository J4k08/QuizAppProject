package com.example.jakobhaglof.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
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

        //TV

        Question q1T = new Question("Vem spelade Harry Potter i filmen Harry Potter?"
                ,"TV","Daniel Radcliffe","Marlon Brando","Daniel Radcliffe","Sven Wolter","Han ljudkillen från polisskolan");
        this.addQuestion(q1T);
        Question q2T = new Question("Vad heter den gröna figuren som dör i Star Wars - Return of the Jedi?","TV","Yoda","Yoda","Jar Jar Binks",
                "Chewbacca","Hans");
        this.addQuestion(q2T);
        Question q3T = new Question("Vem i serien Friends har stort intresse för Dinosaurier?","TV","Ross","Ross","Joey","Monica","Rachel");
        this.addQuestion(q3T);
        Question q4T = new Question("Vem i familjen Macahan är äldst?","TV","Zeb","Zeb","Kate","Luke","Jessie");
        this.addQuestion(q4T);
        Question q5T = new Question("I vilken serie förekommer den talande bilen 'Kitt'?","TV","Knight Rider","Knight Rider",
                "Miami Vice","The Car","Cars");
        this.addQuestion(q5T);
        Question q6T = new Question("Vad är orignaltiteln på TV-serien 'Våra bästa år'?","TV","Days of our Lives",
                "Days of your Lives","Running Sand","DiMera","The Eternal Story");
        this.addQuestion(q6T);
        Question q7T = new Question("Under vilket krig utspelar sig TV-serien 'M*A*S*H'?","TV","Koreakriget","Koreakriget"
                ,"Första Världskriget","Andra Världskriget","Vietnamkriget");
        this.addQuestion(q7T);
        Question q8T = new Question("Vem är äldst av 'Sex & the City'-tjejerna?","TV","Samantha","Samantha","Miranda","Carrie","Charlotte");
        this.addQuestion(q8T);
        Question q9T = new Question("Under vilket årtioende utspelar sig 'Stranger Things'?","TV","80-tal","80-tal","70-tal","90-tal","00-tal");
        this.addQuestion(q9T);
        Question q10T = new Question("Vilket år började 'Game Of Thrones' sändas?","TV","2011","2011","2012","2013","2010");
        this.addQuestion(q10T);

        //Musik

        Question q1M = new Question("Vem är inte en medlem i ABBA?","Musik","Babben Larsson","Björn Ulvaeus","Anni-Frid Lyngstad","Babben Larsson","Agnetha Fältskog");
        this.addQuestion(q1M);
        Question q2M = new Question("I vilket band har Ozzy Osbourne sjungit i?","Musik","Black Sabbath","Grateful Dead","Rainbow","Black sabbath","The Osmonds");
        this.addQuestion(q2M);
        Question q3M = new Question("Vilket band skrev låten 'Hold the line'?","Musik","Toto","Meatloaf","Patti Smith","David Bowie","Toto");
        this.addQuestion(q3M);
        Question q4M = new Question("Vilket år bildades One Direction?","Musik","2012","2012","2013","2011","2010");
        this.addQuestion(q4M);
        Question q5M = new Question("Vem är Martin Eriksson också känd som?","Musik","E-Type","Ziggy Stardust","Starchild","E-Type","Batman");
        this.addQuestion((q5M));
        Question q6M = new Question("Vilket rockband förknippas med Kim Larsen?","Musik","Gasolin'","Gasolin'","Larsen Brothers","Volbeat","Suspekt");
        this.addQuestion(q6M);
        Question q7M = new Question("Vem är född 1947 och grundade bandet 'The Stooges'","Musik","Iggy Pop","Iggy Pop","String","Eric Clapton","Bryan Ferry");
        this.addQuestion(q7M);
        Question q8M = new Question("Jimmy Page och Robert Plant är två medlemmar i vilket band?","Musik","Led Zeppelin","Led Zeppelin","Cream","Dire Straits","Deep purple");
        this.addQuestion(q8M);
        Question q9M = new Question("Vilken artist hade en hit med låten 'Do you really want me'?","Musik","Robyn","Robyn","Molly Sandén","Justin Bieber","Beyonce");
        this.addQuestion(q9M);
        Question q10M = new Question("Vem sa 'vi är populärare än Jesus'?","Musik","John Lennon","John Lennon","Michael Jacksson","Harry Styles","Justin Timberlake");
        this.addQuestion(q10M);

        //historia

        Question q1H = new Question("När föll Berlinmuren?","Historia","1989","1986","1992","1989","1995");
        this.addQuestion(q1H);
        Question q2H = new Question("När dog John F Kennedy?","Historia","1963","1971","1963","1982","1967");
        this.addQuestion(q2H);
        Question q3H = new Question("Vad sägs vara en startande orsak till första världs kriget?","Historia","Skotten i Sarajevo","Finnen i Hamburg",
                "Skotten i Sarajevo","Japanen i Warzawa","Ryssen i Alingsås");
        this.addQuestion(q3H);
        Question q4H = new Question("Vad hette bombplanet som släppte den första atombomben?","Historia","Enola Gay","Princess","Fat Boy"
                ,"Enola Gay","Kingfisher");
        this.addQuestion(q4H);
        Question q5H = new Question("Noas tredje son, lillebror till Sem och Ham hette vad?","Historia","Jafet","Set","Jafet","Bosse","Laban");
        this.addQuestion(q5H);
        Question q6H = new Question("I vilket nutida land ligger ruinerna av Babylon?","Historia","Irak","Irak","Iran","Syrien","Israel");
        this.addQuestion(q6H);
        Question q7H = new Question("Vilket århundrade uppfanns blixtlåset?","Historia","1900-talet","1900-talet","1800-talet","2000-talet","1700-talet");
        this.addQuestion(q7H);
        Question q8H = new Question("Hugin & Munin är två korpar. Vem äger dem?","Historia","Oden","Oden","Tor","Hjalmar","Simon Cowell");
        this.addQuestion(q8H);
        Question q9H = new Question("I vilken svensk stad uppfanns tändstickan?","Historia","Jönköping","Jönköping","Linköping","Göteborg","Skara");
        this.addQuestion(q9H);
        Question q10H = new Question("Vilket år var det sista som svenska folket röstade till en tvåkammarriksdag?","Historia","1968","1968","1932","1956","1984");
        this.addQuestion(q10H);

        //Diverse

        Question q1D = new Question("Vad står MSN för?","Diverse","Microsoft Network","Microsoft Network","Mass Sending Network",
                "Multimedia Server Name","Microsoft Social Network");
        this.addQuestion(q1D);
        Question q2D = new Question("Vad står förkortningen FAQ för?","Diverse","Frequently Asked Questions","Forward A Questions","Frequently Asked Questions",
                "Far And Quick","Fast Answer Quality");
        this.addQuestion(q2D);
        Question q3D = new Question("Vilken spritsort utgör grunden i en äkta Dry Martini?","Diverse","Gin","Gin","Vodka","Dry Vermouth","Rom");
        this.addQuestion(q3D);
        Question q4D = new Question("Vilken komet syntes 1997 och beräknas återkomma om ca 2500 år?","Diverse","Hale Bop","Hale Bop","Swift Tuttle","Halley","Shoemaker");
        this.addQuestion(q4D);
        Question q5D = new Question("Vem skrev den klassiska boken 'Liftarens guide till galaxen'?","Diverse","Douglas Adams","Douglas Adams","George Orwell","Stephen King","Lisa Marklund");
        this.addQuestion(q5D);
        Question q6D = new Question("Vad heter Donal Trumps fru?","Diverse","Melania Trump","Melania Trump","Svetlana Trump","Marina Trump","Melka Trump");
        this.addQuestion(q6D);
        Question q7D = new Question("Vad heter stad på Danska?","Diverse","By","By","Town","Stad","Stat");
        this.addQuestion(q7D);
        Question q8D = new Question("Ungefär hur mycket av vår atmsofär är syre?","Diverse","20%","20%","50%","30%","60%");
        this.addQuestion(q8D);
        Question q9D = new Question("Vilken religion har flest anhängare i världen?","Diverse","Kristemdomen","Kristendomen","Islam","Hinduismen","Buddhismen");
        this.addQuestion(q9D);
        Question q10D = new Question("Vilket sädesslag har kortast ax?","Diverse","Vete","Vete","Råg","Korn","Havre");
        this.addQuestion(q10D);
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

    public ArrayList<Player> getSortedPlayers(){

        Log.d(TAG, "getSortedPlayers: KOMMER IN I SORTED");

        ArrayList<Player> playerList = new ArrayList<>();

        db = this.getReadableDatabase();

        Cursor cursor = db.query(P_TABLE, null, null, null, null, null, P_HIGHSCORE + " DESC","10");
        Log.d(TAG, "getSortedPlayers: HÄMTAT PLAYERS" + cursor);

        if (cursor.moveToFirst()) {
            do {
                Player p = new Player();

                p.setMonkeyID(cursor.getInt(cursor.getColumnIndex(P_MONKEY)));
                p.setName(cursor.getString(cursor.getColumnIndex(P_NAME)));
                p.setHighScore(cursor.getInt(cursor.getColumnIndex(P_HIGHSCORE)));


                playerList.add(p);
            } while (cursor.moveToNext());
        }
        for(int i = 0; i < playerList.size(); i++){
            Log.d(TAG, "getSortedPlayers: " + playerList.get(i).getName() + " " + playerList.get(i).getHighScore());
        }
        cursor.close();
        db.close();

        Log.d(TAG, "PlayerList skapad!");

        return playerList;
    }

    public void updateHighScore(int highScore, String pName) {

        db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(P_HIGHSCORE, highScore);
        String[] selectionArgs = new String[]{pName};

        db.update(P_TABLE, cv, P_NAME + "=?", selectionArgs);

    }

    public void removePlayer(String pName) {

    db = getWritableDatabase();

        String[] selectionArgs = new String[]{pName};
        db.delete(P_TABLE, P_NAME + "=?", selectionArgs);
    }

}