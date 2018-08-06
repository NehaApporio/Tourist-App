package com.example.apporio.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    Gson gson;

   // @BindView(R.id.placeholder)
    PlaceHolderView placeholder;

   // private String url = "https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&h=350";
    List<String> holderDataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ButterKnife.bind(this);
        AndroidNetworking.initialize(this);
        gson = new GsonBuilder().create();

        placeholder = findViewById(R.id.placeholder);


        AndroidNetworking.get("http://demo3755375.mockable.io/data")
                .setPriority(Priority.HIGH)
                .build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                Log.d("****",response);
                ModelMyData modelMyData = gson.fromJson("" + response, ModelMyData.class);
                for (int i = 0; i < modelMyData.getPlaceholder().size(); i++) {
                    placeholder.addView(new DesignView(MainActivity.this, modelMyData.getPlaceholder().get(i)));
                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });


    }


}
