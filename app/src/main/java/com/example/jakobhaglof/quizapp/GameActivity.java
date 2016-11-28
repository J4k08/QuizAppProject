package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private final static String TAG = "GAME_ACTIVITY: ";
    DBHelper db = new DBHelper(this);
    Player player;
    String pName = "";
    ArrayList<String> clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getStringExtra("pName"));

        Log.d(TAG, player.getName());
        clicked = (ArrayList<String>) getIntent().getSerializableExtra("clicked");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

}
