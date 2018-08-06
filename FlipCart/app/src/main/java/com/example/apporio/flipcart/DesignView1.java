package com.example.apporio.flipcart;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Display;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.example.apporio.flipcart.ModelData.FlipcartBean;
import com.example.apporio.flipcart.ModelData.FlipcartBean.ImagesBean;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.example.apporio.flipcart.ModelData.*;
import static com.example.apporio.flipcart.ModelData.FlipcartBean.*;


@Layout(R.layout.horizontalplaceholder)


public class DesignView1  {

    @View(R.id.placeholder2)
    PlaceHolderView placeHolderView2;
    Context context;

    ModelData.FlipcartBean flipcartBean;

    public DesignView1(Context context, FlipcartBean flipcartBean) {

        this.context = context;
        this.flipcartBean = flipcartBean;
    }

    @Resolve
    public void OnResolve() {

        //  flipcartBean.getImages()
        placeHolderView2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        for(int i=0;i<flipcartBean.getImages().size();i++){
            placeHolderView2.addView(new ImageDesign(context,flipcartBean.getImages().get(i)));
        }

    }

}
