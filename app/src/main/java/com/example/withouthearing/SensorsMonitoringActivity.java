package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.example.withouthearing.adapters.SensorsMonitoringAdapter;
import com.example.withouthearing.database.DB;

public class SensorsMonitoringActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sensors_monitoring);

        // TODO put scrollbar and visible selection of row element

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