package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainMenuActivity extends AppCompatActivity {
    private DBHelper db;
    private final static String TAG = "MAIN_MENU_ACTIVITY: ";
    private Player player;
    private String pName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        db = new DBHelper(this);
        Intent i = getIntent();

        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

        Log.d(TAG, "MONKEY ID: " + player.getMonkeyID());

        Log.d(TAG, "onCreate: " + player.getName() + " " + player.getHighScore());

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
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.toolbarMonkey){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
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


    public void sendToGameSettings(View view) {

        Intent intent = new Intent(this, GameSettingsActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);

    }

    public void sendToProfiles(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    public void sendToSettings(View view) {

        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    public void sendToHighScore(View view) {

        Intent intent = new Intent(this, HighScoreActivity.class);
        intent.putExtra("name", pName);
        startActivity(intent);
    }
}