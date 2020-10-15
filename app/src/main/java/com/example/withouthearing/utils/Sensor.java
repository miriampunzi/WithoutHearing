package com.example.withouthearing.utils;

public class Sensor {

    private int imageIDResource;
    private String name;
    private String where;

    public Sensor(int imageIDResource, String name, String where) {
        this.imageIDResource = imageIDResource;
        this.name = name;
        this.where = where;
    }

    public int getImageIDResource() {
        return imageIDResource;
    }

    public void setImageIDResource(int imageIDResource) {
        this.imageIDResource = imageIDResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
