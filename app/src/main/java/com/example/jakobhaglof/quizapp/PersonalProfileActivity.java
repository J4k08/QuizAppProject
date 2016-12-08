package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class PersonalProfileActivity extends AppCompatActivity implements Serializable {
    private DBHelper db;
    private final static String TAG = "PERSONAL_ACTIVITY: ";
    private Player loggedInPlayer;
    private Player clickedPlayer;
    private String pName = "";
    private String clickedName = "";
    private String isFromMenu = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);
        db = new DBHelper(this);
        Intent i = getIntent();

        isFromMenu = i.getStringExtra("isFromMenu");
        Log.d(TAG, "onCreate: " + isFromMenu);

        loggedInPlayer = db.getPlayerFromDB(pName = i.getStringExtra("pName"));
        clickedPlayer = db.getPlayerFromDB(clickedName = i.getStringExtra("clickedPlayer"));

        if (isFromMenu == null){

            displayProfile(clickedPlayer);
        }else if(isFromMenu.equals("Yes")) {
            displayProfile(loggedInPlayer);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem M1 = menu.getItem(0);

        M1.setTitle(loggedInPlayer.getName());

        MenuItem M2 = menu.getItem(1);

        M2.setIcon(loggedInPlayer.getMonkeyID());

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

    public void displayProfile(Player player) {

        TextView name = (TextView) findViewById(R.id.Personal_profile);
        name.setText(player.getName());

        ImageView monkey = (ImageView) findViewById(R.id.monkey_personal);
        monkey.setBackgroundResource(player.getMonkeyID());
    }
}
