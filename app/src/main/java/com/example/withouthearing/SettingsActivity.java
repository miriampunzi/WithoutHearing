package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.SettingsAdapter;
import database.DB;

public class SettingsActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_settings);

        WearableRecyclerView settingsRecyclerView = findViewById(R.id.recyclerView_listSettings);
        settingsRecyclerView.setEdgeItemsCenteringEnabled(true);
        settingsRecyclerView.setCircularScrollingGestureEnabled(true);

        SettingsAdapter notificationsAdapter = new SettingsAdapter(DB.settings);
        settingsRecyclerView.setAdapter(notificationsAdapter);

        WearableLinearLayoutManager settingsLayoutManager = new WearableLinearLayoutManager(this);
        settingsRecyclerView.setLayoutManager(settingsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }
}
