package com.example.apporio.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  APIManager.FETCHER{

    APIManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiManager = new APIManager(this);

        apiManager.callAPI();

    }

    @Override
    public void apiStrted() {
        Toast.makeText(this, "API Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void apiEnded() {

    }
}
