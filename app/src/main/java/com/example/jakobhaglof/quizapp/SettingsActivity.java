package com.example.jakobhaglof.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    Player player;
    String pName = "";
    DBHelper db = new DBHelper(this);

    private final static String TAG = "SETTINGS_ACTIVITY: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));
        Log.d(TAG, "onCreate: " + player.getName());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    public void sendToAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void resetHighScore(View view) {
        //Rensa alla High Scores
    }

    public void removeCurrentProfile(View view) {
        //Ta bort aktuell profil
    }

    public void sendToAddQuestion(View view) {
        Intent intent = new Intent(this, AddQuestionActivity.class);
        startActivity(intent);
    }

    public void SendToRemoveQuestion(View view) {
        Intent intent = new Intent(this, RemoveQuestionActivity.class);
        startActivity(intent);
    }
    
}
