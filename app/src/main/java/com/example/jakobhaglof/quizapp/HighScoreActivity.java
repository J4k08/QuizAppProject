package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_highscores, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.back_to_menu) {

            startActivity(new Intent(this, MainMenuActivity.class ));
            return true;
        } else if (id == R.id.settings) {
            Toast.makeText(this, "Going to settings",Toast.LENGTH_SHORT).show();
            Intent go2SettingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(go2SettingsIntent);
            return true;
        } else if (id == R.id.home) {
            Toast.makeText(this, "Going home",Toast.LENGTH_SHORT).show();
            Intent goHomeIntent = new Intent(this, MainMenuActivity.class);
            startActivity(goHomeIntent);
            return true;
        } else if (id == R.id.play) {
            Intent go2GameIntent = new Intent(this, GameActivity.class);
            startActivity(go2GameIntent);
            return true;
        } else if (id == R.id.info) {
            Toast.makeText(this, "Going to about",Toast.LENGTH_SHORT).show();
            Intent go2AboutIntent = new Intent(this, AboutActivity.class);
            startActivity(go2AboutIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}