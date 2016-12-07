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
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    private final static String TAG = "HIGH_SCORE_ACTIVITY: ";
    private DBHelper db;
    private Player player;
    private String pName = "";
    private GridView gv;
    private ArrayAdapter<Player> gridAdapter;
    private ArrayList<Player> highList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        Log.d(TAG, "onCreate: KOM IN PÅ AKTIVITETEN");
        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

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

        highList = db.getSortedPlayers();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> monkeys = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();


        for(int i = 0; i < highList.size(); i++){

            names.add(highList.get(i).getName());
            monkeys.add(highList.get(i).getMonkeyID());
            scores.add(highList.get(i).getHighScore());

        }

        ListAdapter listList = new CustomAdapter(this, monkeys, names, scores);
        ListView highscoreList = (ListView) findViewById(R.id.highscore_listview);

        highscoreList.setAdapter(listList);


       /** highscoreList.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            }


        );*/

    }
}