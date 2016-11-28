package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.back_to_menu) {
            startActivity(new Intent(this, MainMenuActivity.class ));
            return true;
        }
        if (id == R.id.quitApp){
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendToGameSettings(View view) {

        Intent intent = new Intent(this, GameSettingsActivity.class);
        startActivity(intent);

    }

    public void sendToProfiles(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void sendToSettings(View view) {

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void sendToHighScore(View view) {

        Intent intent = new Intent(this, HighScoreActivity.class);
        startActivity(intent);
    }
}