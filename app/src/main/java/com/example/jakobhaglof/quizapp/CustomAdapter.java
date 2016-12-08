package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by samuelalundborg on 07/12/16.
 */

public class CustomAdapter extends ArrayAdapter<Player> {


    CustomAdapter(Context context, ArrayList<Player> players){
        super(context, R.layout.custom_row, players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        Player player = getItem(position);

        ImageView monkey = (ImageView)customView.findViewById(R.id.row_image_id);
        monkey.setBackgroundResource(player.getMonkeyID());

        TextView name = (TextView) customView.findViewById(R.id.row_name_id);
        name.setText(player.getName());

        TextView score = (TextView) customView.findViewById(R.id.row_score_id);
        score.setText("" + player.getHighScore());

        return customView;
    }

}
