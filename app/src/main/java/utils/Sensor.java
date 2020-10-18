package utils;

import android.widget.ImageView;

public class Sensor {

    private int imageIDResource;
    private String name;
    private String where;
    private String disableTime;

    public Sensor(int imageIDResource, String name, String where, String disableTime) {
        this.imageIDResource = imageIDResource;
        this.name = name;
        this.where = where;
        this.disableTime = disableTime;
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

    public String getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(String disableTime) {
        this.disableTime = disableTime;
    }
}
