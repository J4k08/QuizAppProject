package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.jakobhaglof.quizapp.R.string.player;

public class ProfileActivity extends AppCompatActivity {

    private final static String TAG = "PROFILE_ACTIVITY: ";
    private List<Player> playersList;
    private ArrayAdapter adapter;
    private ArrayList<String> playerNames;
    private DBHelper db;
    private EditText et;
    private int monkeyID;
    private String pName = "";
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = new DBHelper(this);

        playerNames = getNameOfPlayer();
        listProfiles(playerNames);

        ListView list = (ListView) findViewById(R.id.item_list);
        list.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {

                pName = (String) a.getItemAtPosition(i);

                sendToMain(v);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.getItem(2).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
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

    public ArrayList<String> getNameOfPlayer() {

        playersList = db.getAllPlayers();

        ArrayList<String> playerNames = new ArrayList<String>();

        for(int i = 0; i < playersList.size(); i++) {

            playerNames.add(playersList.get(i).getName());
        }

        return playerNames;

    }

    public void saveProfile(View view) {

        et = (EditText)findViewById(R.id.add_name);

        String name = et.getText().toString();
        db = new DBHelper(getApplicationContext());

        player = new Player(0, name, 0);
        player.setMonkeyID(monkeyID);

        db.addPlayer(player);
        playerNames = getNameOfPlayer();

        listProfiles(playerNames);
    }

    public void listProfiles(ArrayList<String> playerNames) {

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);

        ListView lw = (ListView)findViewById(R.id.item_list);

        lw.setAdapter(adapter);

    }

    public void sendToMain(View view) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    public void saveMonkey(View view) {

        if (view.equals(findViewById(R.id.monkey1))){
            monkeyID = R.drawable.ziggymonkey;
        }
        else if (view.equals(findViewById(R.id.monkey2))){
            monkeyID = R.drawable.rupaulmonkey;
        }
        else if (view.equals(findViewById(R.id.monkey3))){
            monkeyID = R.drawable.standardmonkey;
        }
    }

}
