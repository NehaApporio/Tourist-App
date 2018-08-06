package com.example.apporio.flipcartlite;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.widget.GridView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.placeholder3)
public class Grid {

    @View(R.id.placeholder3)
    private PlaceHolderView placeHolderView3;

    Context context;
    ModelData.MainBean mainBean;
    public Grid(Context context,ModelData.MainBean mainBean){
        this.context=context;
        this.mainBean=mainBean;

    }

    @Resolve
    public void OnResolve(){

    placeHolderView3.setLayoutManager(new GridLayoutManager(context, 2));
        for(int i=0;i<mainBean.getData().size();i++){
            placeHolderView3.addView(new ImageDesign(context,mainBean.getData().get(i)));
        }
    }
}
