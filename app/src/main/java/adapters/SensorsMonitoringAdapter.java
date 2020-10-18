package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.withouthearing.DisableTimeDialogActivity;
import com.example.withouthearing.R;
import com.example.withouthearing.SensorsMonitoringListActivity;
import com.example.withouthearing.SingleNotificationActivity;

import java.util.ArrayList;

import utils.Constants;
import utils.Sensor;

public class SensorsMonitoringAdapter extends RecyclerView.Adapter<SensorsMonitoringAdapter.SensorsViewHolder> {

    private SensorsMonitoringListActivity sensorsMonitoringListActivity;
    private ArrayList<Sensor> sensors;

    public SensorsMonitoringAdapter(SensorsMonitoringListActivity sensorsMonitoringListActivity, ArrayList<Sensor> sensors) {
        this.sensorsMonitoringListActivity = sensorsMonitoringListActivity;
        this.sensors = sensors;
    }

    @NonNull
    @Override
    public SensorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sensor, parent, false);
        return new SensorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SensorsViewHolder holder, final int position) {
        holder.whereTextView.setText(sensors.get(position).getWhere());
        holder.sensorNameTextView.setText(sensors.get(position).getName());
        holder.sensorIcon.setImageResource(sensors.get(position).getImageIDResource());
        holder.sensorDisableTime.setText(sensors.get(position).getDisableTime());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openDisableTimeDialog = new Intent(sensorsMonitoringListActivity, DisableTimeDialogActivity.class);
                openDisableTimeDialog.putExtra("position", position);
                sensorsMonitoringListActivity.startActivityForResult(openDisableTimeDialog, Constants.DISABLE_TIME_ACTIVITY_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public static class SensorsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentView;
        ImageView sensorIcon;
        TextView whereTextView;
        TextView sensorNameTextView;
        TextView sensorDisableTime;

        public SensorsViewHolder(@NonNull View itemVIew) {
            super(itemVIew);

            parentView = itemVIew.findViewById(R.id.linearLayout_rowSensor);
            sensorIcon = itemVIew.findViewById(R.id.imageView_rowSensor_icon);
            sensorNameTextView = itemVIew.findViewById(R.id.textView_rowSensor_name);
            whereTextView = itemVIew.findViewById(R.id.textView_rowSensor_where);
            sensorDisableTime = itemVIew.findViewById(R.id.textView_rowSensor_disableTime);
        }
    }
}