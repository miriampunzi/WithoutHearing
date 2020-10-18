package adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.withouthearing.DisableTimeDialogActivity;
import com.example.withouthearing.HouseNotificationListActivity;
import com.example.withouthearing.R;
import com.example.withouthearing.SingleHouseNotificationActivity;

import java.util.ArrayList;

import database.DB;
import utils.Constants;
import utils.HouseNotification;

public class HouseNotificationsAdapter extends RecyclerView.Adapter<HouseNotificationsAdapter.HouseNotificationViewHolder> {

    private ArrayList<HouseNotification> houseNotifications;
    private HouseNotificationListActivity houseNotificationListActivity;

    public HouseNotificationsAdapter(HouseNotificationListActivity houseNotificationListActivity, ArrayList<HouseNotification> houseNotifications) {
        this.houseNotificationListActivity = houseNotificationListActivity;
        this.houseNotifications = houseNotifications;
    }

    @NonNull
    @Override
    public HouseNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification, parent, false);
        return new HouseNotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HouseNotificationViewHolder holder, final int position) {
        if (DB.houseNotifications.get(position).isPriority()) {
            holder.iconNotification.setImageResource(R.drawable.icon_alert);
            holder.iconNotification.setColorFilter(Color.RED);
            holder.whereTextView.setTextColor(Color.RED);
            holder.whatTextView.setTextColor(Color.RED);
            holder.whenTextView.setTextColor(Color.RED);
        }
        else {
            holder.iconNotification.setImageResource(R.drawable.icon_notification);
            holder.whereTextView.setTextColor(Color.YELLOW);
        }

        holder.whereTextView.setText(houseNotifications.get(position).getWhere());
        holder.whatTextView.setText(houseNotifications.get(position).getWhat());
        holder.whenTextView.setText(houseNotifications.get(position).getWhen());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSingleNotification = new Intent(houseNotificationListActivity, SingleHouseNotificationActivity.class);
                openSingleNotification.putExtra("position", position);
                houseNotificationListActivity.startActivityForResult(openSingleNotification, Constants.SINGLE_HOUSE_NOTIFICATION_ACTIVITY);
            }
        });
    }

    @Override
    public int getItemCount() {
        return houseNotifications.size();
    }

    public static class HouseNotificationViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentView;
        ImageView iconNotification;
        TextView whereTextView;
        TextView whatTextView;
        TextView whenTextView;

        public HouseNotificationViewHolder(@NonNull View itemVIew) {
            super(itemVIew);

            parentView = itemVIew.findViewById(R.id.linearLayout_rowNotification);
            iconNotification = itemVIew.findViewById(R.id.imageView_rowElement_icon);
            whereTextView = itemVIew.findViewById(R.id.textView_rowElement_where);
            whatTextView = itemVIew.findViewById(R.id.textView_rowElement_what);
            whenTextView = itemVIew.findViewById(R.id.textView_rowElement_when);
        }
    }
}