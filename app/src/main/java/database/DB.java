package database;

import com.example.withouthearing.R;

import java.util.ArrayList;

import utils.Camera;
import utils.HouseNotification;
import utils.Sensor;
import utils.Setting;

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

    // TODO icon drop
    public static ArrayList<Sensor> sensors = new ArrayList<Sensor>() {{
        add(new Sensor(R.drawable.icon_drop, "Shower Tap", "BATHROOM"));
        add(new Sensor(R.drawable.icon_drop, "Sink", "BATHROOM"));
        add(new Sensor(R.drawable.icon_fire, "Stove", "KITCHEN"));
        add(new Sensor(R.drawable.icon_volume, "Television", "LIVING ROOM"));
        add(new Sensor(R.drawable.icon_fire, "Heater", "BEDROOM"));
    }};

    // TODO adjust icons
    public static ArrayList<Setting> settings = new ArrayList<Setting>() {{
        add(new Setting("Notification", R.drawable.icon_notification));
        add(new Setting("Lights customization", R.drawable.icon_notification));
        add(new Setting("Modify house map", R.drawable.icon_notification));
        add(new Setting("Set priorities", R.drawable.icon_notification));
    }};

    public static ArrayList<Camera> cameras = new ArrayList<Camera>() {{
       add(new Camera("Door Bell", R.mipmap.camera_door_round));
       add(new Camera("Living Room", R.mipmap.camera_livingroom_round));
       add(new Camera("Study Room", R.mipmap.camera_studio_round));
    }};
}
