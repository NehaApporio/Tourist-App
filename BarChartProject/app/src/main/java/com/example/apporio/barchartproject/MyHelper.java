package com.example.apporio.barchartproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper{


    public MyHelper(Context context) {
        super(context, "MyData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="create table myTable(xValues INTEGER,yValues INTEGER,count INTEGER);";
        try {
            sqLiteDatabase.execSQL(createTable);

        }catch (Exception e){

            e.toString();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(int valX, long valY, int count){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("xValues",valX);
        contentValues.put("yValues",valY);
        contentValues.put("count",count);
        db.insert("myTable",null,contentValues);
        db.close();
    }


    public List readData(Context context) {
        SQLiteDatabase database = this.getReadableDatabase();

        String xdata = "";
        String ydata = "";
        String countData = "";

        List datalsit = new ArrayList();

       Cursor cursor =database.rawQuery("select * from myTable",null);

        if (cursor.moveToFirst()) {

            do {

                    xdata += " "+cursor.getString(cursor.getColumnIndex("xValues"));
                    ydata += " "+cursor.getString(cursor.getColumnIndex("yValues"));
                    countData += " "+cursor.getString(cursor.getColumnIndex("count"));

                }
                while (cursor.moveToNext()) ;

                datalsit.add(xdata);
                datalsit.add(ydata);
                datalsit.add(countData);


            }

    //   Toast.makeText(context, ""+cursor.getCount(), Toast.LENGTH_SHORT).show();
            cursor.close();

            return datalsit;
        }


        public int getNumber()
        {
            SQLiteDatabase database = this.getReadableDatabase();

            Cursor cursor = database.rawQuery("select * from myTable",null);;
            return  cursor.getCount();


        }

    }


