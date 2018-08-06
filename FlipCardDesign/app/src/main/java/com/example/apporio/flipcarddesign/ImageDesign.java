package com.example.apporio.flipcarddesign;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


@Layout(R.layout.tinder_card)
public  class ImageDesign {

    @View(R.id.image)
    public ImageView imageView;
    Context context;
    FlipCart.FlipcartviewBean.TinderBean tinderBean;

    public ImageDesign(Context context, FlipCart.FlipcartviewBean.TinderBean tinderBean){
        this.context=context;
        this.tinderBean=tinderBean;

    }

    @Resolve
    public void OnResolve(){

        Log.d("****",tinderBean.getUrl());
        Glide.with(context).load(tinderBean.getUrl()).into(imageView);
    }

}
