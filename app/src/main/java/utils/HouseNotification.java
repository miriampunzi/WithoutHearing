package utils;

import java.sql.Time;

public class HouseNotification {

    private String where;
    private String what;
    private String when;
    private boolean isPriority;

    public HouseNotification(String where, String what, String when, boolean isPriority) {
        this.where = where;
        this.what = what;
        this.when = when;
        this.isPriority = isPriority;
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

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }
}
