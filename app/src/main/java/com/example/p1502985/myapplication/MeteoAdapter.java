package com.example.p1502985.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by p1502985 on 31/03/2017.
 */


public class MeteoAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> meteo_description;
    private final ArrayList<String> meteo_min;
    private final ArrayList<String> meteo_max;


    public MeteoAdapter(Context context, ArrayList<String> description, ArrayList<String> min, ArrayList<String> max) {
        super(context, R.layout.list_meteo, description);
        this.context = context;
        this.meteo_description = description;
        this.meteo_min = min;
        this.meteo_max = max;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_meteo, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(meteo_description.get(position));

        TextView text1 = (TextView) rowView.findViewById(R.id.textView2);
        text1.setText("min : " + meteo_min.get(position));

        TextView text2 = (TextView) rowView.findViewById(R.id.textView3);
        text2.setText("max : " + meteo_max.get(position));


        // Change icon based on name
        String s = meteo_description.get(position);

        System.out.println(s);

        if (s.contains("rain")) {
            imageView.setImageResource(R.mipmap.rain);
        }
        else  if(s.contains("clouds")){
            imageView.setImageResource(R.mipmap.cloud);
        }
        else  if(s.contains("clear")){
            imageView.setImageResource(R.mipmap.sun);
        }


        return rowView;
    }
}