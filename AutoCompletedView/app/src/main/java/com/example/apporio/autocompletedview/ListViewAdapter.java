package com.example.apporio.autocompletedview;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<Model> list;
    ArrayList<Model> arrayList;

    public ListViewAdapter(Context context,List<Model> list){
        this.context=context;
        this.list=list;
        this.arrayList=new ArrayList<Model>();
        layoutInflater=LayoutInflater.from(context);
        this.arrayList.addAll(list);

    }

    public class ViewHolder{
        TextView title,des;
        ImageView icon;
    }
    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
      if(view==null){

          holder=new ViewHolder();
          view=layoutInflater.inflate(R.layout.raw,null);
          holder.title=view.findViewById(R.id.text1);
          holder.des=view.findViewById(R.id.text2);
          holder.icon=view.findViewById(R.id.image);

          view.setTag(holder);

      }else{
          holder=(ViewHolder)view.getTag();
      }
      holder.title.setText(list.get(i).getTitle());
      holder.des.setText(list.get(i).getDes());
      holder.icon.setImageResource(list.get(i).getIcon());

      view.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              //
          }
      });
        return view;
    }

    public void filter(String charText){
    charText=charText.toLowerCase(Locale.getDefault());
    list.clear();

    if(charText.length()==0){
        list.addAll(arrayList);
    }

    else {
        for (Model model : arrayList) {
            if (model.getTitle().toLowerCase(Locale.getDefault()).contains(charText))
            {
                list.add(model);
            }
        }
    }

    notifyDataSetChanged();
    }


}
