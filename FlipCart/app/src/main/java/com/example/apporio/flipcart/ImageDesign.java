package com.example.apporio.flipcart;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


@Layout(R.layout.imagedesign)
  public  class ImageDesign{
  @View(R.id.image)
    public  ImageView imageView;
    private Context context;
    private ModelData.FlipcartBean.ImagesBean imagesBean;

    public ImageDesign(Context context, ModelData.FlipcartBean.ImagesBean imagesBean) {
     this.context=context;
     this.imagesBean=imagesBean;
    }
    @Resolve
    public void OnResolve(){

      Glide.with(context).load(imagesBean.getUrl()).into(imageView);

    }
}
