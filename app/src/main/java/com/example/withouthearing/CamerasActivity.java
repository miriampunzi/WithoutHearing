package com.example.withouthearing;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import database.DB;
import utils.Camera;

public class CamerasActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_cameras);

        ListView camerasList = findViewById(R.id.listView_listCameras);

        ArrayList<String> cameraNames = new ArrayList<>();
        for (Camera camera : DB.cameras)
            cameraNames.add(camera.getName());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cameraNames);
        camerasList.setAdapter(adapter);
        camerasList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent openCameraViewActivity = new Intent(getApplicationContext(), CameraViewActivity.class);
                openCameraViewActivity.putExtra("imageResId", DB.cameras.get(i).getIdResourceView());
                startActivity(openCameraViewActivity);
            }
        });
    }
}
