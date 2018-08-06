package com.example.apporio.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.ArrayList;

public class TrialListViewAdapter extends BaseAdapter{
   Context context;
    ArrayList<MainActivity.ModelFragData> dataModelArrayList;

    private MyInterface myInterface;

   public  TrialListViewAdapter(MyInterface myInterface, Context context, ArrayList<MainActivity.ModelFragData> dataModelArrayList){
       this.context=context;
       this.dataModelArrayList = dataModelArrayList ;
       this.myInterface = myInterface;
   }



    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.item_layout,viewGroup,false);
        ImageView im=view.findViewById(R.id.some_image);
        Button b1=view.findViewById(R.id.button1);
        Button b2=view.findViewById(R.id.button2);
        final TextView name=view.findViewById(R.id.name);
        final TextView des=view.findViewById(R.id.des);
        final TextView quality=view.findViewById(R.id.quality_text);

        final TextView to=view.findViewById(R.id.total);

       MainActivity.ModelFragData modelFragData =  dataModelArrayList.get(i);

        name.setText(""+modelFragData.getText());
        des.setText(""+modelFragData.getDescription());
      //quality.setText(""+modelFragData.get);


        Glide.with(context).load(modelFragData.getImage()).into(im);


       // Glide.with(context).load("data:image/jpeg;base64,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").into(im);


        quality.setText(""+(dataModelArrayList.get(i).getQuality()));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 dataModelArrayList.get(i).setQuality(dataModelArrayList.get(i).getQuality()+1);

                quality.setText(""+(dataModelArrayList.get(i).getQuality()));

                  myInterface.onPlusBtnClicked();




            }
        });

        quality.setText(""+(dataModelArrayList.get(i).getQuality()));

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataModelArrayList.get(i).setQuality(dataModelArrayList.get(i).getQuality()-1);

                quality.setText(""+(dataModelArrayList.get(i).getQuality()));

                myInterface.onMinusBtnClicked();


              /*  thirdones.get(i).setQuality(thirdones.get(i).getQuality()-1);
                quality.setText(""+thirdones.get(i).getQuality());
                myInterface.onMinusBtnClicked();
                */

            }
        });


        return view;
    }
}