package com.example.apporio.tinder;


import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.security.PrivateKey;

@Layout(R.layout.tinder_card_view)
public class Tinder_card {

@View(R.id.profileImageView)
    private ImageView imageView;

@View(R.id.nameAgeTxt)
    private TextView textView;
@View(R.id.locationNameTxt)
    private TextView textView2;
private Profile profile;
private Context context;
private SwipePlaceHolderView swipePlaceHolderView;

public Tinder_card(Profile profile,Context context,SwipePlaceHolderView swipePlaceHolderView){
    this.context=context;
    this.profile=profile;
    this.swipePlaceHolderView=swipePlaceHolderView;

}

@Resolve
    public void OnResolve(){

    Glide.with(context).load(profile.getUrl()).into(imageView);
    textView.setText(""+profile.getName()+","+profile.getPrice());
    textView2.setText(""+profile.getLocation());

}

}
