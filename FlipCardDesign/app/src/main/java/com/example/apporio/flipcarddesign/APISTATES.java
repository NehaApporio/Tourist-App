package com.example.apporio.flipcarddesign;

public interface APISTATES {
    void showLoading();
    void hideLoadinh();
    void onError();
    void onSuccess(String response);
}
