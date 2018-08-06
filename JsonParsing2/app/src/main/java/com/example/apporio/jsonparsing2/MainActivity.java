package com.example.apporio.jsonparsing2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);

        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("http://demo3755375.mockable.io/first")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("*****",""+response);

                        parsejson(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                        Log.d("****","error"+anError.toString());
                    }
                });




    }

    private void parsejson(String response) {

        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONArray jsonArray=jsonObject.optJSONArray("contacts");

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject1=jsonArray.optJSONObject(i);
                String id=jsonObject1.optString("id");
                Log.d("*****","id is : "+id);
                t1.setText(""+id);

                String name=jsonObject1.optString("name");
                t2.setText(""+name);

                String email=jsonObject1.optString("email");
                t3.setText(""+email);
//                Log.d("*****","id is"+id);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
