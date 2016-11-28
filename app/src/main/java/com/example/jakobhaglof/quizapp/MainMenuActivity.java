package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenuActivity extends AppCompatActivity {
    DBHelper db = new DBHelper(this);
    private final static String TAG = "MAIN_MENU_ACTIVITY: ";
    Player player;
    String pName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent i = getIntent();

        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

        Log.d(TAG, "onCreate: " + player.getName() + " " + player.getHighScore());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class ));
            return true;
        }
        if (id == R.id.quitApp){
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