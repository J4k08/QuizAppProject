package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    List<Player> playersList;
    ArrayAdapter adapter;
    ArrayList<String> playerNames;
    DBHelper db;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        DBHelper db = new DBHelper(this);

        playersList = db.getAllPlayers();
        playerNames = getNameOfPlayer();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);

        ListView lw = (ListView)findViewById(R.id.item_list;

        lw.setAdapter(adapter);
    }

    public void sendToGamesettings(View view) {

        Intent intent = new Intent(this,GameSettingsActivity.class);
        startActivity(intent);
    }

    public ArrayList<String> getNameOfPlayer() {

        ArrayList<String> playerNames = new ArrayList<String>();

        for(int i = 0; i < playersList.size(); i++) {

            playerNames.add(playersList.get(i).getName());
        }

        return playerNames;

    }

    public void createPlayer(View view) {

        et = (EditText)findViewById(R.id.nameId);

        Player p1 = new Player(0, et.getText().toString(), 0);

        db.addPlayer(p1);
        db.getAllPlayers();

    }

}
