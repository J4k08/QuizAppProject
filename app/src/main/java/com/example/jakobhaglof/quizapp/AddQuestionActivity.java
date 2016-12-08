package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionActivity extends AppCompatActivity {

    private final static String TAG = "ADD_QUESTION_ACTIVITY: ";
    private DBHelper db;
    private Player player;
    private String pName = "";
    private String isFromMenu = "Yes";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        db = new DBHelper(this);
        Intent i = getIntent();
        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));
        addItemsOnSpinner();
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
        if (id == R.id.quitApp) {
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void addQuestion(View view) {

    }
}
