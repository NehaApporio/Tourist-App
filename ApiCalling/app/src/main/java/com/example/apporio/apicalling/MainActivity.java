package com.example.apporio.apicalling;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    // String url="http://apporioinfolabs.com/ApporiotaxiMaster/public/api/time";


    String s="{\"employee\":{\"name\":\"Neha\",\"id\":2000}}";
    TextView e1,e2;

    String name,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.textView);
        e2=findViewById(R.id.textView2);


            try {
                /*
                URL ur=new URL(url);
               HttpURLConnection con=(HttpURLConnection)ur.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bu=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String value=bu.readLine();
                System.out.println("result is"+value);
                */

                JSONObject obj= new JSONObject(s);
                JSONObject employee = obj.getJSONObject("employee");
                name = employee.getString("name");
                id = employee.getString("id");
                e1.setText(""+name);
                e2.setText(""+id);


            } catch (JSONException e) {


                e.printStackTrace();
            }
        }
    }

