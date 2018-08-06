package com.example.apporio.flipcarddesign;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


   @Layout(R.layout.swipeview)
   public  class Tinder  {

    @View(R.id.swipe)
    private SwipePlaceHolderView swipePlaceHolderView;
    Context context;
    FlipCart.FlipcartviewBean flipcartviewBean;

    public Tinder(Context context, FlipCart.FlipcartviewBean flipcartviewBean){
        this.context=context;
        this.flipcartviewBean=flipcartviewBean;

    }
    @Resolve
    public void OnResolve(){

        for(int i=0;i<flipcartviewBean.getTinder().size();i++){



            swipePlaceHolderView.addView(new ImageDesign(context,flipcartviewBean.getTinder().get(i)));
        }

    }



}
