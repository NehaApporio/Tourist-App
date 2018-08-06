package com.example.apporio.touristapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ViewPager viewPager;
    Gson gson;
    List<Model.ResponseBean> list;
    LocationManager locationManager;

    String nm ="";
    String pl = "";
    String im = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        AndroidNetworking.initialize(getApplicationContext());
        viewPager = findViewById(R.id.viewpager);
        gson = new Gson();

        mapFragment.getMapAsync(this);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                Geocoder coder = new Geocoder(getApplicationContext());

                try {
                    List<Address> addresses = coder.getFromLocationName(pl,1);

                    LatLng latLng = new LatLng(addresses.get(0).getLatitude(),addresses.get(0).getLongitude());

                    mMap.addMarker(new MarkerOptions().position(latLng));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

      private void parse() {
          AndroidNetworking.get("http://snowy-river-1600.getsandbox.com/%20tour")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Model model = gson.fromJson("" + response, Model.class);
                        Log.d("****RESPONSE***",response);
                        list = model.getResponse();
                        viewPager.setAdapter(new ViewPagerAdapter(MapsActivity.this, list, getSupportFragmentManager()));



                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        parse();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            new AlertDialog.Builder(MapsActivity.this)
                    .setMessage("Acccess the phone location")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                        }
                    })
                    .setNegativeButton("Cancle", null)
                    .create()
                    .show();

        }
    }
    private Bitmap getBitmapFromLayout(View view, Context  context) {


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);


        return  bitmap;

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event)
    {
        nm = event.getName();
        pl = event.getPlace();
        im = event.getPic();

    }
    @Override
    protected void onResume() {

        super.onResume();

        EventBus.getDefault().register(this);

    }


    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }





}