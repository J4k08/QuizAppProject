package com.example.jakobhaglof.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    DBHelper db = new DBHelper(this);
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void createPlayer(View view) {

        et = (EditText)findViewById(R.id.nameId);

        Player p1 = new Player(0, et.getText().toString(), 0);

        db.addPlayer(p1);






    }
}
