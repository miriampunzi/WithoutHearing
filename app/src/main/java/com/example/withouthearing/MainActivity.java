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
        setContentView(R.layout.activity_main);

        WearableRecyclerView houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
        houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
        houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);
        WhearableRecyclerViewAdapter whearableRecyclerViewAdapter = new WhearableRecyclerViewAdapter(DB.houseNotifications);
        houseNotificationsRecyclerView.setAdapter(whearableRecyclerViewAdapter);
        WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
        houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }
}
