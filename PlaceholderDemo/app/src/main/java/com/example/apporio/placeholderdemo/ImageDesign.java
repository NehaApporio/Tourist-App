package com.example.apporio.placeholderdemo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


@Layout(R.layout.design)
  public  class ImageDesign  {

    @View(R.id.image)
    public ImageView imageView;
    @View(R.id.textView)
    public TextView textView;

    private Context context;
    private ModelMyData.PlaceholderBean.HolderDataBean holderDataBean;


    public ImageDesign(Context context, ModelMyData.PlaceholderBean.HolderDataBean holderDataBean) {
        this.context=context;
        this.holderDataBean=holderDataBean;

    }

    @Resolve
    public  void OnResolve(){

        Glide.with(context).load(holderDataBean.getUrl()).into(imageView);

        textView.setText(""+holderDataBean.getName());

    }

}
