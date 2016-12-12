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
import android.widget.Toast;

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
    private Button monkey1, monkey2, monkey3;

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

    private ArrayList<String> getNameOfPlayer() {

        playersList = db.getAllPlayers();

        ArrayList<String> playerNames = new ArrayList<String>();

        for(int i = 0; i < playersList.size(); i++) {

            playerNames.add(playersList.get(i).getName());
        }

        return playerNames;

    }

    /**
     * Handles button click. If the playerName array contains the String pname, it'll Toast the user.
     * Else if the Pname contains the wrong set of characters, it'll also Toast the user.
     * else it will instanciate a Player object and call the DBHelper addPlayer(Player)-method
     * and create a profile and save it in the database.
     * @param view
     */
    public void saveProfile(View view) {

        et = (EditText)findViewById(R.id.add_name);

        pName = et.getText().toString();

        if(playerNames.contains(pName)){

            Toast.makeText(this, "Profilnamn taget, försök igen!", Toast.LENGTH_SHORT).show();

        } else if(!pName.matches("^[a-zåäöA-ZÅÄÖ]{3,20}$")){
            Toast.makeText(this, "Profilnamn får endast innehålla a-ö och vara mellan 3-20 tecken långt", Toast.LENGTH_SHORT).show();
        } else {
            db = new DBHelper(getApplicationContext());

            player = new Player(0, pName, 0);
            player.setMonkeyID(monkeyID);

            db.addPlayer(player);
            playerNames = getNameOfPlayer();

            listProfiles(playerNames);
        }
    }

    private void listProfiles(ArrayList<String> playerNames) {

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);

        ListView lw = (ListView)findViewById(R.id.item_list);

        lw.setAdapter(adapter);

    }

    /**
     * handles button click, sends pName with the intent and then starts MainMenuActivity
     * @param view
     */
    public void sendToMain(View view) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra("pName", pName);
        startActivity(intent);
    }

    /**
     * handles a button click, depending on which button the user clicks, that id will be set as
     * the monkeyId. Also if you click one button it'll change the picture to a similiar picture
     * but with a frame around it.
     * @param view
     */
    public void saveMonkey(View view) {

        monkey1 = (Button) findViewById(R.id.monkey1);
        monkey2 = (Button) findViewById(R.id.monkey2);
        monkey3 = (Button) findViewById(R.id.monkey3);

        if (view.equals(findViewById(R.id.monkey1))){
            monkey1.setBackgroundResource(R.drawable.frameziggymonkey);
            monkey2.setBackgroundResource(R.drawable.rupaulmonkey);
            monkey3.setBackgroundResource(R.drawable.standardmonkey);
            monkeyID = R.drawable.ziggymonkey;
        }
        else if (view.equals(findViewById(R.id.monkey2))){
            monkey1.setBackgroundResource(R.drawable.ziggymonkey);
            monkey2.setBackgroundResource(R.drawable.framerupaulmonkey);
            monkey3.setBackgroundResource(R.drawable.standardmonkey);
            monkeyID = R.drawable.rupaulmonkey;
        }
        else if (view.equals(findViewById(R.id.monkey3))){
            monkey1.setBackgroundResource(R.drawable.ziggymonkey);
            monkey2.setBackgroundResource(R.drawable.rupaulmonkey);
            monkey3.setBackgroundResource(R.drawable.framestandardmonkey);
            monkeyID = R.drawable.standardmonkey;
        }
    }

}
