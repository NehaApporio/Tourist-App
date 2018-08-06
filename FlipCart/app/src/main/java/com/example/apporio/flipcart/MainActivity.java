package com.example.apporio.flipcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.View;

public class MainActivity extends AppCompatActivity {


    Gson gson;

     PlaceHolderView placeHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       placeHolderView = findViewById(R.id.placeholder1);
        gson=new Gson();
        AndroidNetworking.initialize(this);
        AndroidNetworking.get("http://demo3755375.mockable.io/flip")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {



                     parseResponse(response);


                //    placeHolderView.addView()
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    private void parseResponse(String response) {

        ModelData modelData=gson.fromJson(""+response,ModelData.class);

        for(int i=0;i<modelData.getFlipcart().size();i++){


         //  if(i==0){
               placeHolderView.addView(new DesignView1(this,modelData.getFlipcart().get(i)));

          // }
        }


    }
}
