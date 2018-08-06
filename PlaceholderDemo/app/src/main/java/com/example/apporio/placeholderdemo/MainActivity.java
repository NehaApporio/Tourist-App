package com.example.apporio.placeholderdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    Gson gson;
    PlaceHolderView placeHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();
        placeHolderView  = findViewById(R.id.place_holder);
        AndroidNetworking.initialize(this);

        AndroidNetworking.get("http://demo3755375.mockable.io/data")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("*****",response);

                        ModelMyData modelMyData = gson.fromJson("" + response, ModelMyData.class);
                        for (int i = 0; i < modelMyData.getPlaceholder().size(); i++) {
                            placeHolderView.addView(new DesignView(MainActivity.this, modelMyData.getPlaceholder().get(i)));
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });


    }
}
