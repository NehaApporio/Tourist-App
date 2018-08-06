package com.example.apporio.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class TrialFragment extends Fragment {


    ListView listView;
    MainActivity.DataModel thirdones ;
    private MyInterface myInterface;

    public TrialFragment(MyInterface myInterface, MainActivity.DataModel thirdones) {
        this.thirdones = thirdones ;
        this.myInterface = myInterface;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.fragment_trial, container, false);
        listView=view.findViewById(R.id.list);

        listView.setAdapter(new TrialListViewAdapter(myInterface, getActivity(),thirdones.getFrag_data()));

//        int totalQuantity = 0;
//        for(int j=0;j<thirdones.size();j++){
//            totalQuantity +=  thirdones.get(j).getQuality();
//        }
//
//        myInterface.setTotalQuantity(""+totalQuantity);


        return view;
    }

}
