package com.example.apporio.first;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyView>{

    List<Tray> list=new ArrayList<>();
    TextView text;
    int x=0;


   public Adapter(ArrayList<Tray> tr,TextView text){
    this.text = text;
   this.list=tr;
   }

    public class MyView extends RecyclerView.ViewHolder{


       public ImageView image;
       public TextView name,des,quality;
        public Button b1,b2;
        public MyView( View itemView) {

            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.text);
            des=itemView.findViewById(R.id.text2);
            quality=itemView.findViewById(R.id.text3);
            b1=itemView.findViewById(R.id.button2);
            b2=itemView.findViewById(R.id.button);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s=quality.getText().toString();
                    Integer in=Integer.parseInt(s);
                    in++;
                    x++;
                    text.setText(""+x);
                    quality.setText(String.valueOf(in));
                    notifyDataSetChanged();


                }
            });
    b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String s=quality.getText().toString();
        Integer in=Integer.parseInt(s);
        in--;
        x--;
        text.setText(""+x);
        quality.setText(String.valueOf(in));
        


    }
});

        }
    }
    @Override
    public MyView onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.design,viewGroup,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(MyView viewHolder, int i) {
       Tray tray=list.get(i);
        viewHolder.name.setText(tray.getName());
        viewHolder.des.setText(tray.getDes());
        viewHolder.quality.setText(tray.getQuality());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
