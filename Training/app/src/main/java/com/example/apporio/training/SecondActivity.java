package com.example.apporio.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements APIManager.FETCHER{


    APIManager apiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        apiManager = new APIManager(this);
    }

    @Override
    public void apiStrted() {

    }

    @Override
    public void apiEnded() {

    }
}
