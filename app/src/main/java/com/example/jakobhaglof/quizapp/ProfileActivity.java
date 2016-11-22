package com.example.jakobhaglof.quizapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void sendToMain(View view) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    public void saveMonkey(View view) {
        Button ib;

        if (view.equals(findViewById(R.id.monkey1))){
            ib = (Button) findViewById(R.id.monkey1);
        }
        else if (view.equals(findViewById(R.id.monkey2))){
            ib = (Button) findViewById(R.id.monkey2);
        }
        else if (view.equals(findViewById(R.id.monkey3))){
            ib = (Button) findViewById(R.id.monkey3);
        }
    }
}
