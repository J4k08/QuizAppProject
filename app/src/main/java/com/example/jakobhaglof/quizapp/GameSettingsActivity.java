package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class GameSettingsActivity extends AppCompatActivity {

    private final static String TAG = "GAME_SETTINGS_ACTIVITY: ";
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    ArrayList<String> clicked = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.back_to_menu) {

            startActivity(new Intent(this, MainMenuActivity.class ));
            return true;
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

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()){

            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("clicked", clicked);
            startActivity(intent);

        }else {
            Toast.makeText(this, R.string.you_need_to_choose_category, Toast.LENGTH_SHORT).show();
        }

    }

    public void checkAllBoxes(View view) {
        checkBox1 = (CheckBox) findViewById(R.id.category1);
        checkBox2 = (CheckBox) findViewById(R.id.category2);
        checkBox3 = (CheckBox) findViewById(R.id.category3);
        checkBox4 = (CheckBox) findViewById(R.id.category4);
        checkBox5 = (CheckBox) findViewById(R.id.categoryAll);
        checkBox6 = (CheckBox) findViewById(R.id.myCategory);

        checkBox1.setChecked(true);

        checkBox2.setChecked(true);

        checkBox3.setChecked(true);

        checkBox4.setChecked(true);
    }

    public void clicked(View view) {
        checkBox1 = (CheckBox) findViewById(R.id.category1);
        checkBox2 = (CheckBox) findViewById(R.id.category2);
        checkBox3 = (CheckBox) findViewById(R.id.category3);
        checkBox4 = (CheckBox) findViewById(R.id.category4);
        checkBox5 = (CheckBox) findViewById(R.id.categoryAll);
        checkBox6 = (CheckBox) findViewById(R.id.myCategory);

        if (checkBox1.isChecked()){
            clicked.add(checkBox1.getText().toString());
        }
        if (checkBox2.isChecked()){
            clicked.add(checkBox2.getText().toString());
        }
        if (checkBox3.isChecked()){
            clicked.add(checkBox3.getText().toString());
        }
        if (checkBox4.isChecked()){
            clicked.add(checkBox4.getText().toString());
        }
        if (checkBox6.isChecked()){
            clicked.add(checkBox6.getText().toString());
        }
    }
}
