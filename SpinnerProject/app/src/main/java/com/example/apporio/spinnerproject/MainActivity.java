package com.example.apporio.spinnerproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    EditText e1;
    Spinner sp1,sp2,sp3;
    Button btn;
    ArrayList<String> list=new ArrayList<>();
    ArrayList<String> list1=new ArrayList<>();
    ArrayList<String> list2=new ArrayList<>();
    String con1,con2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        e1=findViewById(R.id.editText);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        sp3=findViewById(R.id.spinner3);
        btn=findViewById(R.id.button);


        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("http://demo3755375.mockable.io/main")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("&&&&&&",""+response);
                        json(response);

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    private void json(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONArray jsonArray = jsonObject.optJSONArray("selector");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);

                String title = jsonObject1.optString("title");

                list.add(title);


            }

            sp1.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list));




        } catch (JSONException e) {
            e.printStackTrace();


        }
        //second url


        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get("http://demo3755375.mockable.io/second")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("######", "" + response);
                        json2(response);


                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });


    }

    private void json2(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.optJSONArray("select1");
            JSONArray jsonArray1 = jsonObject.optJSONArray("select2");
            for (int j = 0; j < jsonArray.length(); j++) {

                JSONObject jsonObject1 = jsonArray.optJSONObject(j);

                 con1 = jsonObject1.optString("con1");
                   list1.add(con1);

            }


                for (int k = 0; k < jsonArray1.length(); k++) {

                    JSONObject jsonObject1 = jsonArray1.optJSONObject(k);
                     con2 = jsonObject1.optString("con2");
                    list2.add(con2);

                }

        } catch (JSONException e) {
            e.printStackTrace();
        }





        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){

                }
                 else if(i==1){

                     sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list2));
                     sp3.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list2));
                }else if(i==2){
                     sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list1));
                     sp3.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list1));

                 }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        new Logic(this,sp2,sp3,e1,t3,btn);



    }


    }
