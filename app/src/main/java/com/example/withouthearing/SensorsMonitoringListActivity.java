package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.SensorsMonitoringAdapter;
import database.DB;
import utils.Constants;
import utils.SwipeToDeleteCallback;

public class SensorsMonitoringListActivity extends WearableActivity {

    SensorsMonitoringAdapter sensorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_monitoring_sensors);

        // TODO put scrollbar and visible selection of row element

        WearableRecyclerView sensorsRecyclerView = findViewById(R.id.recyclerView_monitoringSensors);
        sensorsRecyclerView.setEdgeItemsCenteringEnabled(true);
        sensorsRecyclerView.setCircularScrollingGestureEnabled(true);

        sensorsAdapter  = new SensorsMonitoringAdapter(this, DB.sensors);
        sensorsRecyclerView.setAdapter(sensorsAdapter);

        WearableLinearLayoutManager sensorsLayoutManager = new WearableLinearLayoutManager(this);
        sensorsRecyclerView.setLayoutManager(sensorsLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.DISABLE_TIME_ACTIVITY_CODE) {
            if (resultCode == Constants.SENSOR_DISABLE_TIME_CHANGED){
                sensorsAdapter.notifyDataSetChanged();
            }
        }
    }
}
