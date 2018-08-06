package com.example.apporio.flipcarddesign;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class APIManager {

    private final String TAG = "APIManager";
    private APISTATES apistates ;
    public APIManager(APISTATES apistates){
        this.apistates = apistates ;
    }


    public void CallGetAPI(String url){
        apistates.showLoading();
        AndroidNetworking.get(""+url).build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                apistates.hideLoadinh();
                apistates.onSuccess(""+response);
                Log.d(""+TAG,""+response);


            }

            @Override
            public void onError(ANError anError) {


                apistates.hideLoadinh();
                apistates.onError();
                Log.d(""+TAG,""+anError.getErrorBody());
            }
        });
    }


}
