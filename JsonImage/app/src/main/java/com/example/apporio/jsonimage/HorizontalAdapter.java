package com.example.apporio.jsonimage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyView2>{


    @Override
    public MyView2 onCreateViewHolder( ViewGroup viewGroup, int i) {


        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.third_layout,viewGroup,false);
        return new MyView2(view);
    }

    @Override
    public void onBindViewHolder( MyView2 myView2, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyView2 extends RecyclerView.ViewHolder{

        ImageView im;
        TextView text;
        public MyView2( View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.text);
            im=itemView.findViewById(R.id.image);


        }
    }
}
