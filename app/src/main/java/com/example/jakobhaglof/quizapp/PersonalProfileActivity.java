package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalProfileActivity extends AppCompatActivity {
    private DBHelper db;
    private final static String TAG = "PERSONAL_PROFILE_ACTIVITY: ";
    private Player player;
    private String pName = "";
    private TextView name;
    private ImageView monkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);
        db = new DBHelper(this);
        Intent i = getIntent();

        player = db.getPlayerFromDB(pName = i.getExtras().getString("pName"));

        name = (TextView) findViewById(R.id.Personal_profile);
        name.setText(player.getName());

        monkey = (ImageView) findViewById(R.id.monkey_personal);
        monkey.setBackgroundResource(player.getMonkeyID());

    }
}
