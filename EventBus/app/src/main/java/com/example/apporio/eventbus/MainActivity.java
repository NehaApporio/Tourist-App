package com.example.apporio.eventbus;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends FragmentActivity{

     FragmentManager fragmentManager;
    private EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.main, new Fragment1());
        ft.add(R.id.main, new Fragment2());

        ft.commit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e1 = editText.getText().toString();
                String e2 ="hello ji";
                EventBus.getDefault().post(new MessageEvent(e1));
                EventBus.getDefault().post(new MessageEvent(e2));
            }
        });


    }



    }
