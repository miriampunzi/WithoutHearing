package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.example.withouthearing.adapters.HouseNotificationsAdapter;
import com.example.withouthearing.database.DB;

public class ListNotificationsActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_notifications);

        // TODO put scrollbar and visible selection of row element

        WearableRecyclerView houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
        houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
        houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);
        HouseNotificationsAdapter houseNotificationsAdapter = new HouseNotificationsAdapter(DB.houseNotifications);
        houseNotificationsRecyclerView.setAdapter(houseNotificationsAdapter);
        WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
        houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }
}
