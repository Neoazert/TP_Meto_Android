package com.example.p1502985.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


//Main
public class MainActivity extends AppCompatActivity {

    private Button json_boutton;
    private ListView vueListe;
    MeteoAdapter adapter;
    ArrayList<String> myStringArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        json_boutton =  (Button) findViewById(R.id.button6);

        vueListe = (ListView) findViewById(R.id.listView);


        myStringArray = new ArrayList<>();



        adapter = new MeteoAdapter(this,myStringArray);


        vueListe.setAdapter(adapter);




        //Json
        json_boutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                System.out.print("aaaaaa " + adapter.getItem(0).toString() + "\n");

                JSONtask tache = new JSONtask();
                tache.execute(adapter,myStringArray);

            }
        });










    }







}
