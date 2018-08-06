package com.example.apporio.placeholderdemo;


import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


@Layout(R.layout.placeholder2)

public class DesignView {

    @View(R.id.place2)
    PlaceHolderView placeHolder;

    ModelMyData.PlaceholderBean placeholderBean;
    Context context;

    public DesignView(Context context, ModelMyData.PlaceholderBean placeholderBean){
        this.context=context;
        this.placeholderBean=placeholderBean;



    }

    @Resolve
    public void OnResolve(){

        placeHolder.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        for(int i=0;i<placeholderBean.getHolder_data().size();i++){

            placeHolder.addView(new ImageDesign(context,placeholderBean.getHolder_data().get(i)));

        }

    }
}
