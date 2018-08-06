package com.example.apporio.flipcarddesign;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity implements APISTATES {

    PlaceHolderView placeHolderView1;
    Gson gson;
    ProgressDialog progressDialog ;
    APIManager apiManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiManager = new APIManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");



        findViewById(R.id.call_api).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiManager.CallGetAPI("http://atulpratise.getsandbox.com/traning_api_one");
            }
        });



        findViewById(R.id.second_api).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiManager.CallGetAPI("http://demo3755375.mockable.io/flipcartview");
            }
        });


              /*  gson=new Gson();

        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get("http://demo3755375.mockable.io/flipcartview")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        json(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });



    }

    private void json(String response) {

        FlipCart flipCart=gson.fromJson(""+response,FlipCart.class);
        for(int i=0;i<flipCart.getFlipcartview().size();i++) {

            if (i == 0) {
                placeHolderView1.addView(new Tinder(this, flipCart.getFlipcartview().get(i)));
                 }else{
                placeHolderView1.addView(new SecondPlaceholder(this, flipCart.getFlipcartview().get(i)));
                 }

            }
            */


        }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoadinh() {
        progressDialog.dismiss();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
}

