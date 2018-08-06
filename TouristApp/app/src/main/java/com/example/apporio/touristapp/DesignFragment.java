package com.example.apporio.touristapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

@SuppressLint("ValidFragment")
public class DesignFragment extends Fragment {

    TextView name,place;
    ImageView imageView;
    RatingBar ratingBar;
    Context context;
    Model.ResponseBean responseBean;
    @SuppressLint("ValidFragment")
    public DesignFragment(Context context, Model.ResponseBean responseBean) {
        this.context=context;
        this.responseBean=responseBean;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_design, container, false);
        name=view.findViewById(R.id.text);
        place=view.findViewById(R.id.text2);
        imageView=view.findViewById(R.id.image);
        ratingBar=view.findViewById(R.id.rating);
        Glide.with(context).load(responseBean.getImage()).into(imageView);
        name.setText(""+responseBean.getName());
        place.setText(""+responseBean.getPlace());
        ratingBar.setNumStars((int) responseBean.getRating());

       EventBus.getDefault().post(new MessageEvent(responseBean.getName(),responseBean.getPlace(),responseBean.getImage()));
      //  EventBus.getDefault().post(new MessageEvent());
        return view;
    }


}
