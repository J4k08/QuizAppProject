package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Player p1 = new Player(10, "Jakob", 10);
        DBHelper db = new DBHelper(this);
        db.addQuestion();
        db.addPlayer(p1);

        db.getAllQuestions();

    }

    public void sendToGamesettings(View view) {

        Intent intent = new Intent(this,GameSettingsActivity.class);
        startActivity(intent);
    }
}
