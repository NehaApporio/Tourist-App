package com.example.apporio.services;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /*TextView textView;
    int day;
    int month;
    int year;
    Date time;
    */
    GraphView graphView;
    MyHelper myHelper;

    SQLiteDatabase sqLiteDatabase;

    private int totalCount=0;
    private String time ="";
    long l;
     String result;
    LineGraphSeries<DataPoint> series=new LineGraphSeries<>(new DataPoint[0]);
    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");

    StringBuffer buffer =new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //   textView=findViewById(R.id.text);

     /*   Calendar ca=Calendar.getInstance();
        int day=ca.get(Calendar.DAY_OF_MONTH);
        int month=ca.get(Calendar.MONTH);
        int year=ca.get(Calendar.YEAR);

        time=Calendar.getInstance().getTime();


        textView.setText(""+day+"/"+(month+1)+"/"+year+"....."+time);
*/
        graphView=findViewById(R.id.graph);
        myHelper=new MyHelper(this);
        sqLiteDatabase=myHelper.getWritableDatabase();
        graphView.addSeries(series);

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return sdf.format(new Date((long)value));
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
        exqInsert();


    }



    private int fetchCountFromDB() {

        String[] columns={"xValues","yValues","count"};
        Cursor cursor=sqLiteDatabase.query("myTable",columns,null,null,null,null,null);
        cursor.moveToNext();
        int count = cursor.getInt(2);
        return count;
    }


    private void exqInsert() {
        long xValues=new Date().getTime();
        int yValues= new Date().getDate();
        int count=0;
        myHelper.insertData(xValues,yValues,count);
        series.resetData(getDataPoint());
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return sdf.format(new Date((long) value));
                } else {
                    return super.formatLabel(value, isValueX);
                }
            }

        });


        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        View view=getLayoutInflater().inflate(R.layout.customdialogue,null);
        TextView textView=view.findViewById(R.id.textView);

        textView.setText(""+buffer);
        builder.setView(view);
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    private DataPoint[] getDataPoint() {
        String[] columns={"xValues","yValues","count"};
        Cursor cursor=sqLiteDatabase.query("myTable",columns,null,null,null,null,null);
        DataPoint[] dp=new DataPoint[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();

           time += cursor.getLong(0);
           try {
              l = Long.parseLong(time);
               DateFormat df = new SimpleDateFormat("HH:mm:ss");
               result = df.format(l);
              //for (int j =0; j <cursor.getCount();j++)
              //{
                   buffer.append(result+", ");

              //}
           }catch (Exception e){
               e.printStackTrace();
           }

            dp[i]=new DataPoint(cursor.getLong(0),cursor.getInt(1));

        }

        Toast.makeText(this, ""+cursor.getCount(), Toast.LENGTH_SHORT).show();
        return dp;
    }


    @Override
    protected void onResume() {
        super.onResume();
      //  totalCount = fetchCountFromDB();
       // totalCount++;


    }
}
