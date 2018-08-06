package com.example.apporio.training;

public class APIManager {


    FETCHER fetcher;


    public APIManager(FETCHER fetcher){
        this.fetcher = fetcher;
    }

    public void callAPI(){
        fetcher.apiStrted();
        // full code of API
    }

    interface FETCHER{

        void apiStrted();
        void apiEnded();
    }

}
