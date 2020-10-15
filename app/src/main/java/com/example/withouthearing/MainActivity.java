package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import database.DB;

public class MainActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoring_sensors_list);

        // TODO put scrollbar and visible selection of row element

        /*WearableRecyclerView houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
        houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
        houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);
        NotificationsAdapter notificationsAdapter = new NotificationsAdapter(DB.houseNotifications);
        houseNotificationsRecyclerView.setAdapter(notificationsAdapter);
        WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
        houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);*/

        WearableRecyclerView sensorsRecyclerView = findViewById(R.id.recyclerView_monitoringSensors);
        sensorsRecyclerView.setEdgeItemsCenteringEnabled(true);
        sensorsRecyclerView.setCircularScrollingGestureEnabled(true);
        SensorsMonitoringAdapter sensorsAdapter = new SensorsMonitoringAdapter(DB.sensors);
        sensorsRecyclerView.setAdapter(sensorsAdapter);
        WearableLinearLayoutManager sensorsLayoutManager = new WearableLinearLayoutManager(this);
        sensorsRecyclerView.setLayoutManager(sensorsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }
}
