package com.example.apporio.placepicker;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity {

    TextView name, addess;
    Button click;
    WebView webView;
    int PLACE_PICKER_REQUEST = 1;
    private final static int MY_PERMISSION_FINE_LOCATION=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        name=findViewById(R.id.textView);
        addess=findViewById(R.id.textView2);
        webView=findViewById(R.id.webview);
        click=findViewById(R.id.button2);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
                try {
                    Intent intent=builder.build(MainActivity.this);
                    startActivityForResult(intent,PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    private void requestPermission() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_FINE_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSION_FINE_LOCATION:
                if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "this app required location", Toast.LENGTH_SHORT).show();
                    finish();
                }

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PLACE_PICKER_REQUEST){
            if(resultCode==RESULT_OK){
                Place place=PlacePicker.getPlace(MainActivity.this,data);
                name.setText(place.getName());
                addess.setText(place.getAddress());
                if(place.getAttributions()==null){
                    webView.loadData("no attribute","text/html:charset=utf-8","UFT-8");
                }else{
                    webView.loadData("no attribute","text/html:charset=utf-8","UFT-8");

                }
            }
        }
    }
}
