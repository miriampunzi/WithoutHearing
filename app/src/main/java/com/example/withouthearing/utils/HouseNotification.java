package com.example.withouthearing.utils;

public class HouseNotification {

    private String where;
    private String what;
    private String when;

    public HouseNotification(String where, String what, String when) {
        this.where = where;
        this.what = what;
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}
