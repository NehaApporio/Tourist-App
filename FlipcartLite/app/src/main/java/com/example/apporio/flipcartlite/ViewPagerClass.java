package com.example.apporio.flipcartlite;


import android.content.Context;
import android.support.v4.view.ViewPager;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;
import java.util.List;

@Layout(R.layout.viewpager)
public class ViewPagerClass {

    @View(R.id.viewpager)
    private ViewPager viewPager;

    Context context;

    ModelData.MainBean mainBean;


    public ViewPagerClass(Context context, ModelData.MainBean dataBeans){

        this.context=context;
        this.mainBean=dataBeans;
    }

    @Resolve
    public void OnResolve(){

        viewPager.setAdapter(new ViewPagerAdapter(context,mainBean.getData()));

    }
}
