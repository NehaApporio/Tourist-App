package com.example.apporio.flipcartlite;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements APISTATES {

    PlaceHolderView placeHolderView1;
    Gson gson;
    ProgressDialog progressDialog ;
    APIManager apiManager;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeHolderView1=findViewById(R.id.placeholder1);
        apiManager = new APIManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        gson = new Gson();

        apiManager.CallApi("http://mysandbox212121.getsandbox.com/new");

        db=new DataBase(this);
        Cursor cursor=db.ReadData();
        if(cursor!=null){
            if(cursor.moveToFirst())
                do{
                String dat=cursor.getString(cursor.getColumnIndex(db.getDatabaseName()));
                    Toast.makeText(this, ""+dat, Toast.LENGTH_SHORT).show();

                }while (cursor.moveToNext());
        }


    }

    private void json(String response) {

        ModelData modelData=gson.fromJson(""+response,ModelData.class);
        for(int i=0;i<modelData.getMain().size();i++){
            //condition
              if(i==0) {
                  placeHolderView1.addView(new ViewPagerClass(this, modelData.getMain().get(i)));
              }else if(i==1){
                 placeHolderView1.addView(new PlaceHolder2(this,modelData.getMain().get(i)));
              }
              else if(i==2){
                  placeHolderView1.addView(new Grid(this,modelData.getMain().get(i)));
              }else if(i==3){
                  placeHolderView1.addView(new PlaceHolder2(this,modelData.getMain().get(i)));
              }
        }
    }

    @Override
    public void showLoading() {
     progressDialog.show();
    }

    @Override
    public void hideLoading() {
    progressDialog.dismiss();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String response) {
      //  Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        json(response);
    }
}
