package com.example.apporio.placepickergson;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Gson gson;
    Context context;
    EditText editText;
    ListViewAdapter listViewAdapter;
    List<ModelData.PredictionsBean> list;
    GoogleApiClient googleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());

        listView=findViewById(R.id.list);
        editText=findViewById(R.id.edittext);
        String ss = editText.getText().toString();
        gson=new Gson();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                  callAPI(charSequence.toString());


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }


    public void callAPI(String ss){
        AndroidNetworking.get("https://maps.googleapis.com/maps/api/place/autocomplete/json?input="+ss+"&key=AIzaSyCm0NKhJ5cbAyGas9zYp8_vZpmltazThL8&session_token=1234567890")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        ModelData modelData=gson.fromJson(""+response,ModelData.class);
                        list = modelData.getPredictions();
                        //for(int i=0;i<modelData.getPredictions().size();i++){
                        listView.setAdapter(new ListViewAdapter(MainActivity.this, list));
                        //}
                    }

                    @Override
                    public void onError(ANError anError) {

                    }

                });


    }

}
