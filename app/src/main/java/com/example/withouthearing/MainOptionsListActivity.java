package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.MainOptionsAdapter;
import adapters.SensorsMonitoringAdapter;
import database.DB;

public class MainOptionsListActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main_options);

        WearableRecyclerView mainOptionsRecyclerView = findViewById(R.id.recycleView_mainOptions);
        mainOptionsRecyclerView.setEdgeItemsCenteringEnabled(true);
        mainOptionsRecyclerView.setCircularScrollingGestureEnabled(true);
        MainOptionsAdapter mainOptionsAdapter = new MainOptionsAdapter(DB.mainOptions);
        mainOptionsRecyclerView.setAdapter(mainOptionsAdapter);
        WearableLinearLayoutManager mainOptionsLayoutManager = new WearableLinearLayoutManager(this);
        mainOptionsRecyclerView.setLayoutManager(mainOptionsLayoutManager);
    }
}
