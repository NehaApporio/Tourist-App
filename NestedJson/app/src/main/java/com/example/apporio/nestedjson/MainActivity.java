package com.example.apporio.nestedjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
     TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);

        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("http://demo3755375.mockable.io/second")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("&&&&&&&&",""+response);

                         jsonparse(response);

                    }

                    @Override
                    public void onError(ANError anError) {

                        Log.d("*******",""+anError.toString());
                    }
                });


    }

    private void jsonparse(String response) {

        try {

            String toatl = "";
            JSONObject object=new JSONObject(response);

            JSONArray jsonArray=object.optJSONArray("Contacts");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.optJSONObject(i);
                JSONArray jr=jsonObject.optJSONArray("Employees");

                for(int j=0;j<jr.length();j++){

                    JSONObject jsonObject1=jr.optJSONObject(j);
                    String name=jsonObject1.optString("name");
                    String id=jsonObject1.optString("id");
                    toatl = toatl.concat("name : "+name+" id:"+id+"\n");


                }

                t1.setText(toatl);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
