package com.example.apporio.jsonimage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyView> {

    Context context;

    ArrayList<String> arrayList;
    public MainAdapter(Context context,ArrayList<String> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public MainAdapter.MyView onCreateViewHolder( ViewGroup viewGroup, int i) {


        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
         View view = inflater.inflate(R.layout.second_layout,viewGroup,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder( MainAdapter.MyView viewHolder, int i) {

        MainAdapter mainAdapter = new MainAdapter(new HorizontalAdapter());
        viewHolder.r2.setAdapter(mainAdapter);



    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyView extends RecyclerView.ViewHolder{

        public  RecyclerView r2;

        public MyView( View itemView) {
            super(itemView);

             r2=itemView.findViewById(R.id.recyler2);


        }
    }
}
