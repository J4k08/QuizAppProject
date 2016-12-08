package com.example.jakobhaglof.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Player player;
    private String pName = "";
    private String isFromMenu = "Yes";
    private DBHelper db;
    private final static String TAG = "SETTINGS_ACTIVITY: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        db = new DBHelper(this);

        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));
        Log.d(TAG, "onCreate: " + player.getName());
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
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.toolbarMonkey){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.toolbarpName) {
            Intent intent = new Intent(this, PersonalProfileActivity.class);
            intent.putExtra("pName", pName);
            intent.putExtra("isFromMenu", isFromMenu);
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

    public void sendToAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("pName", pName);
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
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    public void SendToRemoveQuestion(View view) {
        Intent intent = new Intent(this, RemoveQuestionActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }
    
}
