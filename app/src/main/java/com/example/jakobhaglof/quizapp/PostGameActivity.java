package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

public class PostGameActivity extends AppCompatActivity {

    private final static String TAG = "POST_GAME_ACTIVITY: ";
    private DBHelper db;
    private Player player;
    private String pName = "";
    private String isFromMenu = "Yes";
    private int lastRoundScore;
    private ArrayList<String> clickedCat;
    private String playedCat;
    private TextView TVplayerName, TVplayedCat, TVroundScore, TVplayerHighScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_game);
        db = new DBHelper(this);

        Intent i = getIntent();
        lastRoundScore = i.getExtras().getInt("playerScore");
        clickedCat = i.getStringArrayListExtra("clickedCat");
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

        playedCat = displayCategories(clickedCat);

        displayResult();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem M1 = menu.getItem(0);

        M1.setTitle(player.getName());

        MenuItem M2 = menu.getItem(1);

        M2.setIcon(player.getMonkeyID());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.toolbarMonkey){
            Intent intent = new Intent(this, PersonalProfileActivity.class);
            intent.putExtra("pName", pName);
            intent.putExtra("isFromMenu", isFromMenu);
            startActivity(intent);
        }
        if (id == R.id.toolbarpName) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("pName", pName);
            startActivity(intent);
        }
        if (id == R.id.quitApp){
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    private String displayCategories(ArrayList<String> clickedCat) {

        playedCat = "";

        if(clickedCat.size() == 4) {

            playedCat = "Alla";

        } else {

            playedCat = clickedCat.get(0);
            for (int i = 1; i < clickedCat.size(); i++) {

                playedCat = playedCat + " & " + clickedCat.get(i);
            }
        }
        return playedCat;
    }

    private void displayResult() {

        TVplayerName = (TextView)findViewById(R.id.writePlayerName);
        TVplayerName.setText(player.getName());

        TVplayedCat = (TextView)findViewById(R.id.writePlayedCategory);
        TVplayedCat.setText(playedCat);

        TVroundScore = (TextView)findViewById(R.id.writePointsGame);
        TVroundScore.setText("" + lastRoundScore);

        TVplayerHighScore = (TextView)findViewById(R.id.writePlayerHighScore);
        TVplayerHighScore.setText("" + player.getHighScore());

    }

    /**
     * handles button click, sends pName with the intent and then starts GameSettingsActivity
     * @param view
     */
    public void sendToGameSettings(View view) {

        Intent intent = new Intent(this, GameSettingsActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    /**
     * handles button click, sends pName with the intent and then starts MainMenuActivity
     * @param view
     */
    public void sendToMain(View view) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    /**
     * handles button click, sends pName with the intent and then starts HighScoreActivity.
     * @param view
     */
    public void sendToHighScore(View view) {

        Intent intent = new Intent(this, HighScoreActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }
}
