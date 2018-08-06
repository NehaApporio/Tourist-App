package com.example.apporio.barchartproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyHelper myHelper;
    String result;
    String day;
    long l;
    String xData = "";
    String yData = "";
    SQLiteDatabase sqLiteDatabase;
    private String time = "";
    List list = new ArrayList();
    private BarData barData;

    ListView listView;
    StringBuffer buffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);

        myHelper = new MyHelper(this);
        // sqLiteDatabase = myHelper.getWritableDatabase();

    /*  ArrayList<BarEntry> barEntries=new ArrayList<>();
       barEntries.add(new BarEntry(0,5f));
        barEntries.add(new BarEntry(1,10f));
        barEntries.add(new BarEntry(2,15f));
        barEntries.add(new BarEntry(3,20f));
        barEntries.add(new BarEntry(4,25f));
        barEntries.add(new BarEntry(5,30f));
        barEntries.add(new BarEntry(6,35f));

        BarDataSet barDataSet=new BarDataSet(barEntries,"number");
        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);

        String[] week=new String[]{"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new MyValueFormatter(week));
        */


        //list = myHelper.readData();
      exeInsert();

    }

   private void exeInsert() {
       int xData = new Date().getDay();
       if (xData == 0) {
           day = "Sun";
       } else if (xData == 1) {
           day = "Mon";
       } else if (xData == 2) {
           day = "Tue";
       } else if (xData == 3) {
           day = "Wed";
       } else if (xData == 4) {
           day = "Thur";
       } else if (xData == 5) {
           day = "Fri";
       } else if (xData == 6) {
           day = "Sat";
       }
       long yData = new Date().getTime();
       int count = 0;
       myHelper.insertData(xData, yData, count);

       //  Toast.makeText(this, "" + xData + "/" + yData + "/" + count, Toast.LENGTH_SHORT).show();

      // AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
     //  View view = getLayoutInflater().inflate(R.layout.list, null);
      // TextView textView = view.findViewById(R.id.textView);
      // TextView textView1 = view.findViewById(R.id.textView2);

       ArrayList<String> list1=new ArrayList<>();


       list = myHelper.readData(this);
       final int number=myHelper.getNumber();

       String ss2 = new String("");

       ss2 += ""+day+"  "+number;
       list1.add(ss2);
     //  textView1.setText("" + day);



       ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1);
       listView.setAdapter(adapter);


      //Toast.makeText(this, "number of app open"+number, Toast.LENGTH_SHORT).show();

       String ss = new String("");
       ss += "" + list.get(1);
     //  textView.setText("" + ss);
     //  builder.setView(view);
     //  AlertDialog dialog = builder.create();
    //   dialog.show();


   }
   public class Model{
       ArrayList<String> parent;
       ArrayList<String> day=new ArrayList<>();
        ArrayList<Integer> number=new ArrayList<>();



   }





/*
    public class MyValueFormatter implements IAxisValueFormatter {

        private String[] mvalues;

        public MyValueFormatter(String[] values) {
            this.mvalues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mvalues[(int) value];
        }

    }
    */

}

