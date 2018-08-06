package com.example.apporio.placepickergson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidnetworking.interfaces.StringRequestListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    TextView textView;
    List<ModelData.PredictionsBean> predictionsBeans;

    public ListViewAdapter(Context context, List<ModelData.PredictionsBean> predictionsBeans) {
        this.context = context;
        this.predictionsBeans = predictionsBeans;
    }

    @Override
    public int getCount() {
        return predictionsBeans.size();
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

        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = vi.inflate(R.layout.customlist, viewGroup,false);

        textView = view.findViewById(R.id.text);
        textView.setText(predictionsBeans.get(i).getDescription());
        notifyDataSetChanged();

        return view;
    }

}

