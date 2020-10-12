package database;

import java.util.ArrayList;

import utils.HouseNotification;

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
}
