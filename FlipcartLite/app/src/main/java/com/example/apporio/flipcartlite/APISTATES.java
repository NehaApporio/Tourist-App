package com.example.apporio.flipcartlite;

 public interface APISTATES {

     void showLoading();
     void hideLoading();
     void onError();
     void onSuccess(String response);
}
