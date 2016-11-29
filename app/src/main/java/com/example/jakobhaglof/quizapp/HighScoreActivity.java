package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    private final static String TAG = "HIGH_SCORE_ACTIVITY: ";
    DBHelper db = new DBHelper(this);
    Player player;
    String pName = "";
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));
        addItemsOnSpinner();
        addListenerOnSpinnerItemSelection();
    }

    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.get_new_category);
        List<String> list = new ArrayList<>();
        list.add("Film & TV");
        list.add("Historia");
        list.add("Musik");
        list.add("Diverse");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.get_new_category);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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

}