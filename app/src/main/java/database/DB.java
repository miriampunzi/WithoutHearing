package database;

import com.example.withouthearing.R;

import java.util.ArrayList;

import utils.HouseNotification;
import utils.MainOption;
import utils.Sensor;

public class DB {

    public static ArrayList<HouseNotification> houseNotifications = new ArrayList<HouseNotification>() {{
        add(new HouseNotification("KITCHEN", "Tap open", "Now"));
        add(new HouseNotification("BEDROOM", "TV vol = 80%", "01:25 PM"));
        add(new HouseNotification("OUTSIDE", "Raining", "11:03 AM"));
        add(new HouseNotification("BATHROOM", "Shower open", "07:15 AM"));
        add(new HouseNotification("LIVINGROOM", "Air condition on", "Yesterday"));
        add(new HouseNotification("KITCHEN", "Tap open", "2 days ago"));
        add(new HouseNotification("BEDROOM", "TV vol = 80%", "2 days ago"));
        add(new HouseNotification("OUTSIDE", "Raining", "2 days ago"));
        add(new HouseNotification("BATHROOM", "Shower open", "2 days ago"));
        add(new HouseNotification("LIVINGROOM", "Air condition on", "3 days ago"));
    }};

    public static ArrayList<Sensor> sensors = new ArrayList<Sensor>() {{
        add(new Sensor(R.drawable.icon_drop, "Shower Tap", "BATHROOM"));
        add(new Sensor(R.drawable.icon_drop, "Sink", "BATHROOM"));
        add(new Sensor(R.drawable.icon_fire, "Stove", "KITCHEN"));
        add(new Sensor(R.drawable.icon_volume, "Television", "LIVING ROOM"));
        add(new Sensor(R.drawable.icon_fire, "Heater", "BEDROOM"));
    }};

}
