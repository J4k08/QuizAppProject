package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.back_to_menu) {

            startActivity(new Intent(this, MainMenuActivity.class ));
            return true;
        } else if (id == R.id.play) {
            Intent go2GameIntent = new Intent(this, GameActivity.class);
            startActivity(go2GameIntent);
            return true;
        } else if (id == R.id.home) {
            Toast.makeText(this, "Going home",Toast.LENGTH_SHORT).show();
            Intent goHomeIntent = new Intent(this, MainMenuActivity.class);
            startActivity(goHomeIntent);
            return true;
        } else if (id == R.id.highscores) {
            Toast.makeText(this, "Going to highscores",Toast.LENGTH_SHORT).show();
            Intent go2HighscoresIntent = new Intent(this, HighScoreActivity.class);
            startActivity(go2HighscoresIntent);
            return true;
        } else if (id == R.id.info) {
            Toast.makeText(this, "Going to about",Toast.LENGTH_SHORT).show();
            Intent go2AboutIntent = new Intent(this, AboutActivity.class);
            startActivity(go2AboutIntent);
            return true;
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
