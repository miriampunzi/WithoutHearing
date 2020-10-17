package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.ImageView;

public class CameraViewActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_camera);

        Intent intent = getIntent();
        int resId = intent.getIntExtra("imageResId", -1);

        System.out.println(resId);

        ImageView cameraImage = findViewById(R.id.imageView_viewCamera_image);
        cameraImage.setImageResource(resId);
    }
}