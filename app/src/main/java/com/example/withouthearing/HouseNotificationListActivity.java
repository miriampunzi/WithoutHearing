package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.HouseNotificationsAdapter;
import database.DB;
import utils.SwipeToDeleteCallback;

public class HouseNotificationListActivity extends WearableActivity {

    WearableRecyclerView houseNotificationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_notifications);

        houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
        houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
        houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);

        HouseNotificationsAdapter houseNotificationsAdapter = new HouseNotificationsAdapter(this, DB.houseNotifications);
        houseNotificationsRecyclerView.setAdapter(houseNotificationsAdapter);

        WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
        houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(houseNotificationsAdapter));
        itemTouchHelper.attachToRecyclerView(houseNotificationsRecyclerView);

        // Enables Always-on
        setAmbientEnabled();
    }
}
