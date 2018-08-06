package com.example.apporio.flipcartlite;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class APIManager {

    private final String TAG="API Manager";
    private APISTATES apistates;

    public APIManager(APISTATES apistates){
        this.apistates=apistates;


    }
        public void CallApi(String url){
        apistates.showLoading();
            AndroidNetworking.get(""+ url)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            apistates.hideLoading();
                            apistates.onSuccess(""+response);
                            Log.d(""+TAG+"",response);

                        }

                        @Override
                        public void onError(ANError anError) {

                            apistates.hideLoading();
                        }
                    });
        }
}
