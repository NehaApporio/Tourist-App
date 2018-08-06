package com.example.apporio.flipcartlite;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.placeholder2)
public class PlaceHolder2 {

    @View(R.id.placeholder2)
    private PlaceHolderView placeHolderView2;
    Context context;
    ModelData.MainBean mainBean;
    public PlaceHolder2(Context context,ModelData.MainBean mainBean){
        this.context=context;
        this.mainBean=mainBean;

    }
     @Resolve
    public void OnResolve(){

         placeHolderView2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
         for(int i=0;i<mainBean.getData().size();i++){
             placeHolderView2.addView(new ImageDesign(context,mainBean.getData().get(i)));
         }
     }

}
