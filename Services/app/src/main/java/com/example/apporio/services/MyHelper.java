package com.example.apporio.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {


    public MyHelper(Context context) {
        super(context, "MyData", null, 1);
        //onCreate(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable="create table myTable(xValues INTEGER,yValues INTEGER,count INTEGER);";
       // sqLiteDatabase.execSQL(createTable);

      try {
          sqLiteDatabase.execSQL(createTable);

      }catch (Exception e){

          e.toString();

      }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        Log.d("######",
                "Upgrading database from version " + oldVersion + " to " + newVersion);
    }
    public void insertData(long valX,int valY,int count){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("xValues",valX);
        contentValues.put("yValues",valY);
        contentValues.put("count",count);
        db.insert("myTable",null,contentValues);
    }
}
