package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import database.DB;
import utils.HouseNotification;

public class SingleHouseNotificationActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_single_notification);

        Intent openSingleNotification = getIntent();
        int position = openSingleNotification.getIntExtra("position", -1);

        if (position != -1) {
            HouseNotification currentHouseNotification = DB.houseNotifications.get(position);

            TextView where = findViewById(R.id.textView_singleNotification_where);
            where.setText(currentHouseNotification.getWhere());
            TextView when = findViewById(R.id.textView_singleNotification_when);
            when.setText(currentHouseNotification.getWhen());
            TextView what = findViewById(R.id.textView_singleNotification_what);
            what.setText(currentHouseNotification.getWhat());
        }
    }
}
