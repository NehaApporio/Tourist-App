package com.example.apporio.touristapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ViewPagerAdapter  extends FragmentPagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    TextView name, place;
    ImageView imageView;
    RatingBar ratingBar;
    List<Model.ResponseBean> responseBeans;

    public ViewPagerAdapter(Context context, List<Model.ResponseBean> responseBeans, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        this.responseBeans = responseBeans;
    }

    @Override
    public Fragment getItem(int i) {
        return new DesignFragment(context,responseBeans.get(i));

    }

    @Override
    public int getCount() {
        return responseBeans.size();
    }


}
