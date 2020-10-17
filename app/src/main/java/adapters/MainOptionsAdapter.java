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

import com.example.withouthearing.ControlsActivity;
import com.example.withouthearing.HouseNotificationListActivity;
import com.example.withouthearing.R;
import com.example.withouthearing.SingleNotificationActivity;

import java.util.ArrayList;

import utils.HouseNotification;
import utils.MainOption;

public class MainOptionsAdapter extends RecyclerView.Adapter<MainOptionsAdapter.MainOptionsViewHolder> {

    private ArrayList<MainOption> mainOptions;

    public MainOptionsAdapter(ArrayList<MainOption> mainOptions) {
        this.mainOptions = mainOptions;
    }

    @NonNull
    @Override
    public MainOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main_option, parent, false);
        return new MainOptionsAdapter.MainOptionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainOptionsViewHolder holder, final int position) {
        holder.icon.setImageResource(mainOptions.get(position).getImageIDResource());
        holder.name.setText(mainOptions.get(position).getName());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                switch (position) {
                    case 0: // notifications
                        Intent openHouseNotificationsListActivity = new Intent(context, HouseNotificationListActivity.class);
                        context.startActivity(openHouseNotificationsListActivity);
                        break;

                    case 1: // controls
                        Intent openControlsViewActivity = new Intent(context, ControlsActivity.class);
                        context.startActivity(openControlsViewActivity);
                        break;

                    case 2: // settings
                        // TODO open settings activity
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainOptions.size();
    }

    public static class MainOptionsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentView;
        ImageView icon;
        TextView name;

        public MainOptionsViewHolder(@NonNull View itemVIew) {
            super(itemVIew);

            parentView = itemVIew.findViewById(R.id.linearLayout_rowMainOption);
            icon = itemVIew.findViewById(R.id.imageView_rowMainOption_icon);
            name = itemVIew.findViewById(R.id.textView_rowMainOption_name);
        }
    }
}
