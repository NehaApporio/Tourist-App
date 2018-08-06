package com.example.apporio.first;

public class Tray {
    String name;
    String des;
    String quality;

    public Tray(String neha, String android, String q) {

     this.name=neha;
     this.des=android;
     this.quality=q;
 }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


}
