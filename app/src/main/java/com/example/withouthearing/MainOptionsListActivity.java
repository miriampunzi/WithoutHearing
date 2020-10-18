package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

public class MainOptionsListActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main_options);
    }

    public void openHouseNotificationView(View view) {
        Intent openNotificationView = new Intent(this, HouseNotificationListActivity.class);
        startActivity(openNotificationView);
    }

    public void openControlsView(View view) {
        Intent openControlsView = new Intent(this, ControlsActivity.class);
        startActivity(openControlsView);
    }

    public void openSettingsView(View view) {
        Intent openSettingsView = new Intent(this, SettingsActivity.class);
        startActivity(openSettingsView);
    }
}
