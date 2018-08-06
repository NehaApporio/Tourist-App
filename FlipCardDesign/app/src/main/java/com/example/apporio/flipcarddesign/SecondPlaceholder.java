package com.example.apporio.flipcarddesign;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.placeholder2)
public class SecondPlaceholder {
    @View(R.id.placeholder2)
     private PlaceHolderView placeHolderView2;
    FlipCart.FlipcartviewBean flipcartviewBean;
    Context context;
    public SecondPlaceholder(Context context, FlipCart.FlipcartviewBean flipcartviewBean){
        this.context=context;
        this.flipcartviewBean=flipcartviewBean;


    }
    @Resolve
    public void OnResolve(){

        placeHolderView2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        for (int i=0;i<flipcartviewBean.getTinder().size();i++){

            placeHolderView2.addView(new ImageDesign(context,flipcartviewBean.getTinder().get(i)));
        }

    }
}
