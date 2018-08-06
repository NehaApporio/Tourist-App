package com.example.apporio.flipcarddesign;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class Utils  {

        Gson gson=new Gson();

        Context context;
        FlipCart.FlipcartviewBean flipcartviewBean;


        public Utils(Context context, FlipCart.FlipcartviewBean flipcartviewBean){
            this.context=context;
            this.flipcartviewBean=flipcartviewBean;


            AndroidNetworking.get("http://demo3755375.mockable.io/flipcartview")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                          json(response);
                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });

        }

    private void json(String response) {


        FlipCart flipCart=gson.fromJson(""+response,FlipCart.class);


        }


}
