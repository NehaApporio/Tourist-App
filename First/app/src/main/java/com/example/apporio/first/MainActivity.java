package com.example.apporio.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
TextView text;
RecyclerView.LayoutManager mLayoutManager;
ArrayList<Tray> tr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list);
        text=findViewById(R.id.textView);
        adapter=new Adapter(tr,text);
        mLayoutManager=new LinearLayoutManager(this);
        setData();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);


    }
    public void setData() {
        Tray tray = new Tray("Neha", "Android", "0");
        tr.add(tray);

        tray= new Tray("Neha", "Android", "0");
        tr.add(tray);

         tray = new Tray("Neha", "Android", "0");
        tr.add(tray);

         tray=new Tray("Neha","Android","0");
        tr.add(tray);


        tray=new Tray("Neha","Android","0");
        tr.add(tray);

         tray=new Tray("Neha","Android","0");
        tr.add(tray);

         tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);
        tray=new Tray("Neha","Android","0");
        tr.add(tray);


    }







}
