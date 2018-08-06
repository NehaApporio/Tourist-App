package com.example.apporio.placeholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

import butterknife.BindView;

@Layout(R.layout.holder1)
public class DesignView {

     private Context context;

     @View(R.id.placeholder1)
      PlaceHolderView placeHolderView1;

     private ModelMyData.PlaceholderBean placeholderBean;

     public DesignView(Context context, ModelMyData.PlaceholderBean placeholderBeans){
         this.context=context;
         this.placeholderBean = placeholderBeans;


     }

    @Resolve
    public void OnResolve(){

         placeHolderView1.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


         for(int i=0;i<placeholderBean.getHolder_data().size();i++){

             placeHolderView1.addView(new ImageDesign(context,placeholderBean.getHolder_data().get(i)));

         }

}




}
