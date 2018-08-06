package com.example.apporio.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {



    private ArrayList<MainActivity.DataModel> dataModels;

    private MyInterface myInterface;
    public PagerAdapter(MyInterface myInterface, FragmentManager supportFragmentManager, ArrayList<MainActivity.DataModel> dataModels
                        ) {
        super(supportFragmentManager);
        this.dataModels = dataModels;
        this.myInterface = myInterface;

    }

    @Override
    public Fragment getItem(int i) {
           return  new TrialFragment(myInterface,dataModels.get(i));
    }

    @Override
    public int getCount() {

        return dataModels.size();

    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

                switch (position){
                    case 0:
                        return dataModels.get(0).getFrag_name();
                    case 1:
                        return dataModels.get(1).getFrag_name();
                    case 2:
                        return dataModels.get(2).getFrag_name();
                    case 3:
                        return dataModels.get(3).getFrag_name();

                    case 4:
                        return dataModels.get(4).getFrag_name();



                }



        return null;
    }


    }




