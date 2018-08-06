package com.example.apporio.autocompletedview;

public class Model {

    String Title;
    String Des;
    int icon;

    public Model(String title, String des, int icon) {
        Title = title;
        Des = des;
        this.icon = icon;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getDes() {
        return this.Des;
    }

    public int getIcon() {
        return this.icon;
    }




}
