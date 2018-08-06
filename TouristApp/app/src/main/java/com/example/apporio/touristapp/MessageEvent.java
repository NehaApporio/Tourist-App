package com.example.apporio.touristapp;

public class MessageEvent {

    String name;
    String place;

    public MessageEvent(String name, String place, String pic) {
        this.name = name;
        this.place = place;
        this.pic = pic;
    }

    String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
