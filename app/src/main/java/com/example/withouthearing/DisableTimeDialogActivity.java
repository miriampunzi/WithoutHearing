package com.example.withouthearing;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableDialogActivity;
import android.view.View;
import android.widget.TimePicker;

import database.DB;
import utils.Constants;


public class DisableTimeDialogActivity extends WearableActivity {

    int positionSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_disable_time);

        Intent openTimeDialog = getIntent();
        positionSensor = openTimeDialog.getIntExtra("position", -1);

        TimePicker picker = (TimePicker) findViewById(R.id.timePicker_viewDisableTime);
        picker.setIs24HourView(true);
    }

    public void goBack(View view) {
        finish();
    }

    public void disableMonitoring(View view) {
        // TODO take real time input
        DB.sensors.get(positionSensor).setDisableTime("3 min left");
        setResult(Constants.SENSOR_DISABLE_TIME_CHANGED);
        finish();
    }
}
