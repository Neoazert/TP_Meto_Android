package com.example.p1502985.myapplication;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by p1502985 on 17/03/2017.
 */
public class JSONtask extends AsyncTask<Object, Void, String> {

    ArrayAdapter<String> adapter;


    ArrayList<String> meteo_description;
    ArrayList<String> meteo_min;
    ArrayList<String> meteo_max;


    @Override
    protected String doInBackground(Object... objects) {


        adapter = (ArrayAdapter) objects[0];
        meteo_description = (ArrayList<String>)  objects[1];
        meteo_description.clear();

        meteo_min = (ArrayList<String>)  objects[2];
        meteo_min.clear();

        meteo_max = (ArrayList<String>)  objects[3];
        meteo_max.clear();

        System.out.println("meteo");


        String inputLine;
        String text ="";


        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=Lyon&appid=b7cfdf2e38dda687e8e6230fa4ffe331");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));



            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
                text +=inputLine;


            }

            JSONObject reader = new JSONObject(text);
            JSONObject sys  = reader.getJSONObject("city");

            JSONArray list = reader.getJSONArray("list");


            System.out.println("Ville : " + sys.getString("name"));
            System.out.println("list : " + list.toString());
            System.out.println("list Lenght : " + list.length());

            int nombreDeJourPrev = 5;
            for(int i =0;i<nombreDeJourPrev;i++) {




                System.out.println("\n\n-------------------" + i);


                JSONObject reader2 = new JSONObject(list.getString(i));
                JSONObject main = reader2.getJSONObject("main");

                System.out.println("Main.temp : " + main.getString("temp"));

                //adapter.add(main.getString("temp"));



                System.out.println("min : " + main.getString("temp_min"));
                meteo_min.add(main.getString("temp_min"));

                System.out.println("max : " + main.getString("temp_max"));
                meteo_max.add(main.getString("temp_max"));

                JSONArray weather = reader2.getJSONArray("weather");
                System.out.println("weather : " + weather.toString());

                //8System.out.println("weather lenght : " + weather.length());

                System.out.println("weather meteo : " + weather.get(0));

                JSONObject meteo = (JSONObject) (JSONObject) weather.get(0);

                System.out.println(" meteo : " + meteo.get("description"));


                meteo_description.add(meteo.getString("description"));


            }







            in.close();

        }catch (Exception e){
            System.out.println("erreur " + e);
        }

        return null;
    }



    @Override
    protected void onPostExecute(String text) {
    adapter.notifyDataSetChanged();


    }

}
