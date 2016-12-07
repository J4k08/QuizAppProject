package com.example.jakobhaglof.quizapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by samuelalundborg on 07/12/16.
 */

public class CustomAdapter extends ArrayAdapter<Player> {

    CustomAdapter(Context context, ArrayList<Integer> monkeys, ArrayList<String> names, ArrayList<Integer> scores){
        super(context, R.layout.custom_row, monkeys, names, scores);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        ImageView monkey = (ImageView) customView.findViewById(R.id.row_image_id);
        TextView name = (TextView) customView.findViewById(R.id.row_name_id);
        TextView score = (TextView) customView.findViewById(R.id.row_score_id);


        return customView;
    }

}
