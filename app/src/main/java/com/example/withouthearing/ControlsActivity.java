package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

public class ControlsActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_controls);
    }

    public void openCamerasListActivity(View view) {
        Intent openCamerasListActivity = new Intent(this, CamerasActivity.class);
        startActivity(openCamerasListActivity);
    }

    public void openSensorsListActivit(View view) {
        Intent openSensorsListActivit = new Intent(this, SensorsMonitoringListActivity.class);
        startActivity(openSensorsListActivit);
    }

    public void openHouseMapOverviewActivity(View view) {
        Intent openHouseMapOverviewActivity = new Intent(this, HouseMapOverviewActivity.class);
        startActivity(openHouseMapOverviewActivity);
    }
}
