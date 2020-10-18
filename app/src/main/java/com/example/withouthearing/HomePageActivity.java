package com.example.withouthearing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import database.DB;
import utils.Constants;
import utils.HouseNotification;
import utils.MyFirebaseMessagingService;
import utils.NotificationSender;

public class HomePageActivity extends WearableActivity {

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.view_home_page);
        updateUI();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home_page);
        updateUI();

        //MyFirebaseMessagingService.getToken(this);
    }

    private void updateUI() {
        ImageView statusImageView = findViewById(R.id.imageView_homePage_status);
        TextView statusTextView = findViewById(R.id.textView_homePage_text);
        TextView whereTextView = findViewById(R.id.textView_homePage_where);

        HouseNotification priorityNotification = null;
        for (HouseNotification houseNotification : DB.houseNotifications) {
            if (houseNotification.isPriority()) {
                priorityNotification = houseNotification;
                break;
            }
        }

        if (DB.houseNotifications.size() == 0) {
            statusImageView.setImageResource(R.drawable.icon_ok);
            statusImageView.setColorFilter(Color.GREEN);
            statusTextView.setText("You've everything under control!");
            whereTextView.setVisibility(View.GONE);
        }
        else if (priorityNotification != null) {
            statusImageView.setImageResource(R.drawable.icon_alert);
            statusImageView.setColorFilter(Color.RED);
            statusTextView.setText(priorityNotification.getWhat());
            whereTextView.setVisibility(View.VISIBLE);
            whereTextView.setText(priorityNotification.getWhere());
            whereTextView.setTextColor(Color.RED);
        }
        else if (DB.houseNotifications.size() == 1) {
            HouseNotification houseNotification = DB.houseNotifications.get(0);
            statusImageView.setImageResource(R.drawable.icon_notification);
            statusImageView.setColorFilter(Color.YELLOW);
            statusTextView.setText(houseNotification.getWhat());
            whereTextView.setVisibility(View.VISIBLE);
            whereTextView.setText(houseNotification.getWhere());
            whereTextView.setTextColor(Color.YELLOW);
        }
        else {
            statusImageView.setImageResource(R.drawable.icon_notification);
            statusImageView.setColorFilter(Color.YELLOW);
            statusTextView.setText("You have some notifications to read");
            whereTextView.setVisibility(View.GONE);
        }
    }

    public void openMainOptions(View view) {
        Intent openMainOptions = new Intent(this, MainOptionsListActivity.class);
        startActivity(openMainOptions);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.SINGLE_HOUSE_NOTIFICATION_ACTIVITY) {
            if (resultCode == Constants.DELETED_HOUSE_NOTIFICATION){

            }
        }
    }
}