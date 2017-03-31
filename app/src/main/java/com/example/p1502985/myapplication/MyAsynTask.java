package com.example.p1502985.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by p1502985 on 17/03/2017.
 */
public class MyAsynTask extends AsyncTask<Object, Void, String> {

    TextView tv;
    @Override
    protected String doInBackground(Object... objects) {
        System.out.println("background");
        String inputLine="";
        tv = (TextView) objects[0];
        String text="";

        try {
            URL url = new URL("http://10.0.2.2:80/time");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));


            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);

                if (inputLine != null)
                    text += inputLine;
            }
            in.close();

        }catch (Exception e){
            System.out.println("erreur " + e);
        }

        return text;
    }

    @Override
    protected void onPostExecute(String text) {
        super.onPostExecute(text);
        tv.setText(text);
    }
}
