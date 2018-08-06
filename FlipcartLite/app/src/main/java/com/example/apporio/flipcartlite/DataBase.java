package com.example.apporio.flipcartlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "flipcart";
    private static final String TABLE_NAME = "TOTAL";
    private static final String COLUMN_NAME = "result";
    Context context;

    public DataBase(Context context) {
        super(context, DATABASE_NAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table total(result TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS total");
        onCreate(sqLiteDatabase);

    }

    public void WriteData(String data){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("result",data);
        db.insert("total",null,values);
        db.close();
    }
    public Cursor ReadData(){
        String val;
        int i=0;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_NAME},null,null,null,null,null);
        return cursor;
    }
}
