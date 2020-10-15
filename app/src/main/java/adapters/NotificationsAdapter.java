package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.withouthearing.R;
import com.example.withouthearing.SingleNotificationActivity;

import java.util.ArrayList;

import utils.HouseNotification;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.HouseNotificationViewHolder> {

    private ArrayList<HouseNotification> houseNotifications;

    public NotificationsAdapter(ArrayList<HouseNotification> houseNotifications) {
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
        holder.whereTextView.setText(houseNotifications.get(position).getWhere());
        holder.whatTextView.setText(houseNotifications.get(position).getWhat());
        holder.whenTextView.setText(houseNotifications.get(position).getWhen());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent openSingleNotification = new Intent(context, SingleNotificationActivity.class);
                openSingleNotification.putExtra("position", position);

                context.startActivity(openSingleNotification);
            }
        });
    }

    @Override
    public int getItemCount() {
        return houseNotifications.size();
    }

    public static class HouseNotificationViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentView;
        TextView whereTextView;
        TextView whatTextView;
        TextView whenTextView;

        public HouseNotificationViewHolder(@NonNull View itemVIew) {
            super(itemVIew);

            parentView = itemVIew.findViewById(R.id.linearLayout_rowNotification);
            whereTextView = itemVIew.findViewById(R.id.textView_rowElement_where);
            whatTextView = itemVIew.findViewById(R.id.textView_rowElement_what);
            whenTextView = itemVIew.findViewById(R.id.textView_rowElement_when);
        }
    }
}