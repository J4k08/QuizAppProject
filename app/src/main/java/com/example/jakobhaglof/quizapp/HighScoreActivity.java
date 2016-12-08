package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity implements Serializable {

    private final static String TAG = "HIGH_SCORE_ACTIVITY: ";
    private DBHelper db;
    private Player player;
    private String clickedPlayer = "";
    private String pName = "";
    private String isFromMenu = "Yes";
    private ArrayList<Player> highList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

        ListView highScoreList = (ListView) findViewById(R.id.highscore_listview);

        highScoreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {

                Object item = a.getItemAtPosition(i);
                clickedPlayer = item.toString();

                sendToPersonal(v);
            }
        });

        writeHighScore();

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

        if (id == R.id.toolbarMonkey) {
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
        if (id == R.id.quitApp) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void writeHighScore() {

        ListView highscoreList = (ListView) findViewById(R.id.highscore_listview);

        highList = db.getSortedPlayers();

        ListAdapter listList = new CustomAdapter(this, highList);

        highscoreList.setAdapter(listList);

    }

   public void sendToPersonal(View view) {
       Intent intent = new Intent(HighScoreActivity.this, PersonalProfileActivity.class);
       intent.putExtra("pName", pName);
       intent.putExtra("clickedPlayer", clickedPlayer);

       startActivity(intent);
    }
}
