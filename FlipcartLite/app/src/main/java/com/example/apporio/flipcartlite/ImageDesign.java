package com.example.apporio.flipcartlite;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;

@Layout(R.layout.imagedesign)
public class ImageDesign {

    @View(R.id.image)
    private ImageView imageView;
    @View(R.id.text)
    private TextView textView;
    @View(R.id.button1)
    private Button button1;
    @View(R.id.button2)
    private Button button2;
    Context context;
    ModelData.MainBean.DataBean dataBean;
    ArrayList<ModelData> list;

    public ImageDesign(Context context, ModelData.MainBean.DataBean dataBean){
        this.context=context;
        this.dataBean=dataBean;


    }

    @Resolve
    public void OnResolve(){
        Glide.with(context).load(dataBean.getUrl()).into(imageView);

    }
    @Click(R.id.button1)
    private void OnClick(){
        /////////////////
    }

}
