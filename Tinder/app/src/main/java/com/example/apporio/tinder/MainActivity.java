package com.example.apporio.tinder;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SwipePlaceHolderView swipePlaceHolderView;
    ImageButton im1, im2;
   private Context context;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipePlaceHolderView = findViewById(R.id.swipe);
        im1 = findViewById(R.id.acceptBtn);
        im2 = findViewById(R.id.rejectBtn);


        context=getApplicationContext();
        context = getApplicationContext();

        swipePlaceHolderView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.swipe_msg)
                        .setSwipeOutMsgLayoutId(R.layout.swipe_out_msg));

        Gson gson=new Gson();
        AndroidNetworking.initialize(getApplicationContext());

            AndroidNetworking.get("http://demo3755375.mockable.io/tinder")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            Json(response);
                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });

            //swipePlaceHolderView.addView(new Tinder_card(profile, context, swipePlaceHolderView));

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipePlaceHolderView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipePlaceHolderView.doSwipe(true);
            }
        });


    }

    private List<Profile> Json(String response) {

        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "profile.json"));
            List<Profile> profileList = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                Profile profile = gson.fromJson(array.getString(i), Profile.class);
                profileList.add(profile);
            }
            return profileList;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }

    private String loadJSONFromAsset(Context context, String s) {

        String json = null;
        InputStream is=null;
        try {
            AssetManager manager = context.getAssets();
           // Log.d(TAG,"path "+jsonFileName);
           // is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
