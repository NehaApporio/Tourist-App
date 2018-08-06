package com.example.apporio.jsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

TextView t1,t2,t3;
    String id;
    String name;
    String email;

    String url = "http://demo3755375.mockable.io/first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          t1 = findViewById(R.id.textView);
          t2 = findViewById(R.id.textView2);
          t3 = findViewById(R.id.textView3);

        AndroidNetworking.initialize(getApplicationContext());

//        new Call().execute();


        callApi();

    }

    private void callApi() {

        AndroidNetworking.get(url)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        parseJson(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(MainActivity.this, "Error...", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void parseJson(String response) {

        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONArray jsonArray=jsonObject.optJSONArray("contacts");

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject1=new JSONObject(String.valueOf(i));

                String id=jsonObject1.optString("id");
                Log.d("$$$$$$$",""+id);
                String name=jsonObject1.optString("name");
                Log.d("$$$$$$$",""+name);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public class Call extends AsyncTask<String, String, String> {

            @Override
            protected String doInBackground(String... strings) {


                try {
                    URL u = new URL(url);

                    HttpURLConnection con = (HttpURLConnection) u.openConnection();
                    con.setRequestMethod("GET");
                    con.connect();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String val=reader.readLine();

                    JSONObject obj = new JSONObject(val);

                    JSONArray contacts = obj.optJSONArray("contacts");

                    for(int i=0;i<contacts.length();i++){
                        JSONObject jsonObject = contacts.optJSONObject(i);
                        id = jsonObject.getString("id");
                        name = jsonObject.getString("name");
                        email = jsonObject.getString("email");

                        t1.setText("" + id);
                        t2.setText("" + name);
                        t3.setText("" + email);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

               return null;
            }

    }
}