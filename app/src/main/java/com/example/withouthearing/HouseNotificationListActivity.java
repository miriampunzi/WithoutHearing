package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.NotificationsAdapter;
import database.DB;

public class HouseNotificationListActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_notifications);

        // TODO put scrollbar and visible selection of row element

        WearableRecyclerView houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
        houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
        houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);
        NotificationsAdapter notificationsAdapter = new NotificationsAdapter(DB.houseNotifications);
        houseNotificationsRecyclerView.setAdapter(notificationsAdapter);
        WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
        houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }
}
