package com.example.apporio.tinder;

public class Profile {


    /**
     * url : https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?cs=srgb&dl=car-vehicle-luxury-112460.jpg&fm=jpg
     * name : AMG
     * price : 50000
     * location : New York
     * age : 100000
     */

    private String url;
    private String name;
    private String price;
    private String location;
    private String age;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
