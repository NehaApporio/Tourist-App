package com.example.apporio.placeholder;

import android.content.Context;
import android.view.ViewDebug;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


import static com.example.apporio.placeholder.R.id.image;
import static com.example.apporio.placeholder.R.id.placeholder1;


@Layout(R.layout.design1)

 public class ImageDesign  {


        @View(R.id.image)    private ImageView imageView;
        @View(R.id.text)     private TextView textView;

    Context context;

    String s;

    private ModelMyData.PlaceholderBean.HolderDataBean holderDataBean;

     public ImageDesign(Context context, ModelMyData.PlaceholderBean.HolderDataBean holderDataBean) {
         this.context=context;


         this.holderDataBean = holderDataBean;

     }




    @Resolve
     public   void OnResolve(){

         Glide.with(context).load(holderDataBean.getUrl()).into(imageView);

         textView.setText(""+holderDataBean.getName());


     }




 }
