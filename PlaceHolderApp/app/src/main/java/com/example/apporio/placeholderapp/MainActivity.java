package com.example.apporio.placeholderapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {


    private Context context;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image);

        loadimage();

    }

    private void loadimage() {

        Glide.with(context).load(R.drawable.ic_launcher_background).into(imageView);
    }
}
