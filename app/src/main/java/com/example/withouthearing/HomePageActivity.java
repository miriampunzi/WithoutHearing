package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

public class HomePageActivity extends WearableActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home_page);
    }

    public void openMainOptions(View view) {
        Intent openMainOptions = new Intent(this, MainOptionsListActivity.class);
        startActivity(openMainOptions);
    }
}