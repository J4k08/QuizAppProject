package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private final static String TAG = "GAME_ACTIVITY: ";
    private DBHelper db;
    private int rndNumber;
    private int playerScore = 0;
    private int timer;
    private int playedTime;
    private int correctGuesses = 0;
    private Player player;
    private String pName = "";
    private String guess = "";
    private ArrayList<String> clickedCat;
    private ArrayList<Question> gameQuestions;
    private ArrayList<String> answers;
    private Button btn, btn1, btn2, btn3, btn4;
    private Game game;
    private TextView que, qTimer, currentPoints;
    private CountDownTimer countDownTimer;
    private boolean isBackPressed = false;
    private MediaPlayer mpC, mpW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        qTimer = (TextView) findViewById(R.id.setQuestionTime);

        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getStringExtra("pName"));

        Log.d(TAG, player.getName());
        clickedCat = i.getStringArrayListExtra("clickedCat");
        mpC = MediaPlayer.create(this, R.raw.correct_answer);
        mpW = MediaPlayer.create(this, R.raw.wrong_answer);
        mpC.setVolume(1.0f,1.0f);


        game = new Game(this, 10000, clickedCat, player);
        gameQuestions = game.prepGame(clickedCat);
        rndNumber = 0;

        setQuestions();
        timer = game.getTimer();

        playGame(gameQuestions);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem M1 = menu.getItem(0);

        M1.setTitle(player.getName());

        MenuItem M2 = menu.getItem(1);

        M2.setIcon(player.getMonkeyID());

        menu.getItem(2).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.quitApp) {
            countDownTimer.cancel();
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    private void playGame(ArrayList<Question> questions) {

        timer = 11000;
        startTimer();

        answers = game.shuffleAnswers(questions, rndNumber);

        que.setText(questions.get(rndNumber).getQuestion());
        btn1.setText(answers.get(0));
        btn2.setText(answers.get(1));
        btn3.setText(answers.get(2));
        btn4.setText(answers.get(3));

    }

    /**
     * handles a button click, when a button is clicked the method will call Game.roundGuess() and
     * cancel the timer. If the user gets the answer right it will colour that button green, otherwise
     * it will color it red. After it will call the guessDelay() method
     * @param view
     */
    public void btnGuess(View view) throws IOException {

        disableButtons();

        btn = (Button)view;
        guess = btn.getText().toString();
        playerScore += game.roundGuess(guess, gameQuestions.get(rndNumber), timer);
        currentPoints = (TextView) findViewById(R.id.setPoints);
        currentPoints.setText(" " + playerScore);

        playedTime += 11 - timer/1000;
        Log.d(TAG, "btnGuess: " + playedTime);
        countDownTimer.cancel();

        if(guess.equals(gameQuestions.get(rndNumber).getCorrectAnswer())) {
            btn.setBackgroundResource(R.drawable.btngreen);
            correctGuesses++;
            mpC.start();

        }
        else{
            btn.setBackgroundResource(R.drawable.btnred);
            mpW.start();
        }
        guessDelay();

    }

    private void setQuestions() {

        que = (TextView) findViewById(R.id.setQuestion);
        btn1 = (Button) findViewById(R.id.btnChoice1);
        btn2 = (Button) findViewById(R.id.btnChoice2);
        btn3 = (Button) findViewById(R.id.btnChoice3);
        btn4 = (Button) findViewById(R.id.btnChoice4);
    }

    private void startTimer() {

        Log.d(TAG, "startTimer: " + timer);

        countDownTimer = new CountDownTimer(timer, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                qTimer.setText("" + millisUntilFinished / 1000);
                Log.d(TAG, "onTick: " + millisUntilFinished / 1000);
                timer = (int) millisUntilFinished;

            }

            public void onFinish() {

                qTimer.setText("0");
                timeOutMsg();
                disableButtons();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rndNumber++;
                        playGame(gameQuestions);
                    }
                }, 2000);
            }

        }.start();
    }

    private void timeOutMsg() {

        Log.d(TAG, "timeOutMsg: Detta skrivs ut i onFinished");
        Toast.makeText(this, "Tiden tog slut!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {

        countDownTimer.cancel();
        isBackPressed = true;

        Intent intent = new Intent(this, GameSettingsActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    /**
     * Method for a delay, it gives a 2 second delay, after the delay the buttons are enabled again
     * and if the rndNumber variable is 10, it will update the Player object's Highscore and start
     * PostGameActivity.
     */
    public void guessDelay(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                if(mpC.isPlaying()){
                    mpC.reset();
                } else if(mpW.isPlaying()) {
                    mpW.reset();
                }

                btn.setBackgroundResource(R.drawable.btn);
                rndNumber++;
                btn1.setEnabled(true); btn2.setEnabled(true); btn3.setEnabled(true); btn4.setEnabled(true);

                if(rndNumber == 10) {

                    Intent i = new Intent(GameActivity.this, PostGameActivity.class);

                    countDownTimer.cancel();
                    if(playerScore > player.getHighScore()) {
                        db.updateHighScore(playerScore, pName);
                    }

                    i.putExtra("playedTime", playedTime);
                    i.putExtra("pName", pName);
                    i.putExtra("playerScore", playerScore);
                    i.putExtra("correctGuesses", correctGuesses);
                    i.putStringArrayListExtra("clickedCat", clickedCat);

                    startActivity(i);
                } else if(!isBackPressed) {
                        playGame(gameQuestions);
                    }
            }
        },2000);
    }

    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
    }


}