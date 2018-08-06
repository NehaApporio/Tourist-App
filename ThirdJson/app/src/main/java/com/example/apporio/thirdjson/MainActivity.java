package com.example.apporio.thirdjson;

import android.app.ProgressDialog;
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

    TextView t1,t2,t3,t4,t5;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         t1=findViewById(R.id.text);
         t2=findViewById(R.id.text2);
         t3=findViewById(R.id.text3);
         t4=findViewById(R.id.text4);
         t5=findViewById(R.id.text5);

        AndroidNetworking.initialize(getApplicationContext());

        progressDialog = new ProgressDialog(MainActivity.this);

        progressDialog.setTitle("Please Wait...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        AndroidNetworking.get("http://demo3755375.mockable.io/th")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("*******",""+response);
                        json(response);
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(ANError anError) {

                        progressDialog.dismiss();
                    }
                });
    }

    private void json(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONArray jsonArray=jsonObject.optJSONArray("Dept");
            for(int i=0;i<jsonArray.length();i++){

                JSONObject obj=jsonArray.getJSONObject(i);

                JSONArray jr1=obj.optJSONArray("Employess");
                for(int j=0;j<jr1.length();j++){

                    JSONObject obj2=jr1.getJSONObject(j);
                    String name=obj2.optString("name");
                    String id=obj2.optString("id");
                    String address=obj2.optString("address");

                    t1.setText(""+name);
                    t2.setText(""+id);
                    t3.setText(""+address);

                }

                JSONArray jr2=obj.getJSONArray("Student");
                for(int k=0;k<jr2.length();k++){

                   JSONObject obj3=jr2.getJSONObject(k);
                   String name2=obj3.optString("name");
                   String roll=obj3.optString("roll");
                   t4.setText(""+name2);
                   t5.setText(""+roll);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
