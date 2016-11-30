package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private final static String TAG = "GAME_ACTIVITY: ";
    DBHelper db;
    int clickCounter;
    Player player;
    String pName = "";
    ArrayList<String> clickedCat;
    ArrayList<Question> gameQuestions;
    TextView que;
    Button btn1; Button btn2; Button btn3; Button btn4;
    Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clickCounter = 0;
        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getStringExtra("pName"));

        startQuestion();
        Log.d(TAG, player.getName());
        clickedCat = i.getStringArrayListExtra("clickedCat");

        if(clickedCat.size() == 0) {
            Log.d(TAG, "onCreate: clickedCat är 0 stor");
        }
        game = new Game(this, 100, clickedCat , player);

        gameQuestions = game.prepGame(clickedCat);


        Log.d(TAG, "onCreate: "+ gameQuestions.get(clickCounter).getQuestion());;
        Log.d(TAG, "onCreate: "+ gameQuestions.get(clickCounter).getCategory());;
        Log.d(TAG, "onCreate: "+ gameQuestions.get(clickCounter).getChoice1());

        while(clickCounter < 5) {

            playGame(gameQuestions);

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("pName", pName);
            startActivity(intent);
        }
        if (id == R.id.quitApp) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void playGame (ArrayList<Question> questions) {

            que.setText(questions.get(clickCounter).getQuestion());
            btn1.setText(questions.get(clickCounter).getChoice1());
            btn2.setText(questions.get(clickCounter).getChoice2());
            btn3.setText(questions.get(clickCounter).getChoice3());
            btn4.setText(questions.get(clickCounter).getChoice4());

        }

    public void categoryBoxes(View view) {

        Question q = gameQuestions.get(clickCounter);
        String guess = view.toString();

        game.roundGuess(guess, q, player);

        clickCounter ++;
    }
    public void startQuestion() {

        que=(TextView) findViewById(R.id.setQuestion);
        btn1 = (Button)findViewById(R.id.btnChoice1);
        btn2 = (Button)findViewById(R.id.btnChoice2);
        btn3 = (Button)findViewById(R.id.btnChoice3);
        btn4 = (Button)findViewById(R.id.btnChoice4);

    }
}
