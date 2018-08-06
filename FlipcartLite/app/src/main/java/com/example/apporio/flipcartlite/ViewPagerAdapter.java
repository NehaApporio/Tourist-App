package com.example.apporio.flipcartlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

   Context context;
   List<ModelData.MainBean.DataBean> dataBean;
   LayoutInflater layoutInflater;

   public ViewPagerAdapter(Context context, List<ModelData.MainBean.DataBean> dataBean){
       this.context=context;
       this.dataBean=dataBean;


   }
    @Override
    public int getCount() {
        return dataBean.size();
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        ImageView imageView;
       layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       ModelData.MainBean.DataBean dataBeanModel = dataBean.get(position);

       View view= layoutInflater.inflate(R.layout.imagedesign,container,false);
       imageView=view.findViewById(R.id.image);
       Glide.with(context).load(dataBeanModel.getUrl()).into(imageView);
       // ((ViewPager) container).addView(itemView);
        ((ViewPager)container).addView(view);
        return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // ((ViewPager) container).removeView((RelativeLayout) object);
        ((ViewPager)container).removeView((ImageView)object);


    }
}
