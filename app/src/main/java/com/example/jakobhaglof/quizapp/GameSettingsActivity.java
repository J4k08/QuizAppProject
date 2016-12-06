package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class GameSettingsActivity extends AppCompatActivity {

    private final static String TAG = "GAME_SETTINGS: ";
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4,
    checkBox5, checkBox6;
    private DBHelper db;
    private ArrayList<String> clickedCat = new ArrayList<>();
    private String pName = "";
    private Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getStringExtra("pName"));
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

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
        if (id == R.id.quitApp){
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }


    public void sendToGame(View view) {

        checkBox1 = (CheckBox) findViewById(R.id.category1);
        checkBox2 = (CheckBox) findViewById(R.id.category2);
        checkBox3 = (CheckBox) findViewById(R.id.category3);
        checkBox4 = (CheckBox) findViewById(R.id.category4);
        checkBox5 = (CheckBox) findViewById(R.id.categoryAll);
        checkBox6 = (CheckBox) findViewById(R.id.myCategory);

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()
                || checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()){

            Intent i = new Intent(this, GameActivity.class);
            i.putStringArrayListExtra("clickedCat", clickedCat);
            i.putExtra("pName", pName);

            startActivity(i);

        }else {
            Toast.makeText(this, R.string.you_need_to_choose_category, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "sendToGame: Funkar inte!");
        }

    }

    public void checkAllBoxes(View view) {

        checkBox1 = (CheckBox) findViewById(R.id.category1);
        checkBox2 = (CheckBox) findViewById(R.id.category2);
        checkBox3 = (CheckBox) findViewById(R.id.category3);
        checkBox4 = (CheckBox) findViewById(R.id.category4);
        checkBox5 = (CheckBox) findViewById(R.id.categoryAll);
        checkBox6 = (CheckBox) findViewById(R.id.myCategory);

        checkIfChecked();

    }

    public void clicked(View view) {
        checkBox1 = (CheckBox) findViewById(R.id.category1);
        checkBox2 = (CheckBox) findViewById(R.id.category2);
        checkBox3 = (CheckBox) findViewById(R.id.category3);
        checkBox4 = (CheckBox) findViewById(R.id.category4);
        checkBox5 = (CheckBox) findViewById(R.id.categoryAll);
        checkBox6 = (CheckBox) findViewById(R.id.myCategory);

        addOrRemoveChecked();

    }
    public void addOrRemoveChecked() {

        if (checkBox1.isChecked() && (!clickedCat.contains("TV"))){
            clickedCat.add("TV");
        } else if (!checkBox1.isChecked()){
            clickedCat.remove("TV");
        }
        if (checkBox2.isChecked() && (!clickedCat.contains("Historia"))){
            clickedCat.add("Historia");
        } else if (!checkBox2.isChecked()){
            clickedCat.remove("Historia");
        }
        if (checkBox3.isChecked() && (!clickedCat.contains("Musik"))){
            clickedCat.add("Musik");
        } else if (!checkBox3.isChecked()){
            clickedCat.remove("Musik");
        }
        if (checkBox4.isChecked() && (!clickedCat.contains("Diverse"))){
            clickedCat.add("Diverse");
        } else if (!checkBox4.isChecked()){
            clickedCat.remove("Diverse");
        }
    }
    public void checkIfChecked() {

        if(checkBox5.isChecked()) {
            checkBox1.setChecked(true);
            checkBox2.setChecked(true);
            checkBox3.setChecked(true);
            checkBox4.setChecked(true);
        } else if (!checkBox5.isChecked()) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
        }
        addOrRemoveChecked();

    }
}
