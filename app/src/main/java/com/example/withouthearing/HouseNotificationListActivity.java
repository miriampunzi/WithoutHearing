package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import adapters.HouseNotificationsAdapter;
import database.DB;
import utils.Constants;

public class HouseNotificationListActivity extends WearableActivity {

    WearableRecyclerView houseNotificationsRecyclerView;
    HouseNotificationsAdapter houseNotificationsAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.list_house_notifications);
        updateUI();

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_house_notifications);
        updateUI();

        // Enables Always-on
        setAmbientEnabled();
    }

    private void updateUI() {
        if (DB.houseNotifications.size() != 0) {
            TextView emptyBoxTextView = findViewById(R.id.textView_listHouseNotifications_emptyBox);
            emptyBoxTextView.setVisibility(View.GONE);

            houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
            houseNotificationsRecyclerView.setVisibility(View.VISIBLE);
            houseNotificationsRecyclerView.setEdgeItemsCenteringEnabled(true);
            houseNotificationsRecyclerView.setCircularScrollingGestureEnabled(true);

            houseNotificationsAdapter = new HouseNotificationsAdapter(this, DB.houseNotifications);
            houseNotificationsRecyclerView.setAdapter(houseNotificationsAdapter);

            WearableLinearLayoutManager houseNotificationsLayoutManager = new WearableLinearLayoutManager(this);
            houseNotificationsRecyclerView.setLayoutManager(houseNotificationsLayoutManager);
        }
        else {
            TextView emptyBoxTextView = findViewById(R.id.textView_listHouseNotifications_emptyBox);
            emptyBoxTextView.setVisibility(View.VISIBLE);

            houseNotificationsRecyclerView = findViewById(R.id.recyclerView_fragmentMenu_menuOptions);
            houseNotificationsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.SINGLE_HOUSE_NOTIFICATION_ACTIVITY) {
            if (resultCode == Constants.DELETED_HOUSE_NOTIFICATION){
                houseNotificationsAdapter.notifyDataSetChanged();
            }
        }
    }
}
