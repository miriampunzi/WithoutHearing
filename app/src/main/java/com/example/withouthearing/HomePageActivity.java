package com.example.withouthearing;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

public class HomePageActivity extends WearableActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home_page);
    }

}