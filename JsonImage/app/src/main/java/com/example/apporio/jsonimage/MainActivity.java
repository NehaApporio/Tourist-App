package com.example.apporio.jsonimage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyler);


        MainAdapter mainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mainAdapter);


        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("http://demo3755375.mockable.io/img")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("&&&&&",""+response);
                        json(response);
                    }

                    @Override
                    public void onError(ANError anError) {


                    }
                });

    }

    private void json(String response) {

        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONArray jsonArray=jsonObject.optJSONArray("images");
            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject1=jsonArray.optJSONObject(i);
                String name=jsonObject1.optString("name");

                String pic=jsonObject1.optString("pic");


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
