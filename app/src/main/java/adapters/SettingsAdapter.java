package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.withouthearing.R;

import java.util.ArrayList;

import utils.Setting;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {

    private ArrayList<Setting> settings;

    public SettingsAdapter(ArrayList<Setting> settings) {
        this.settings = settings;
    }

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_icon_text, parent, false);
        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, final int position) {
        holder.text.setText(settings.get(position).getName());
        holder.icon.setImageResource(settings.get(position).getImageIDResource());
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }

    public static class SettingsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentView;
        ImageView icon;
        TextView text;

        public SettingsViewHolder(@NonNull View itemVIew) {
            super(itemVIew);

            parentView = itemVIew.findViewById(R.id.linearLayout_rowIconText);
            icon = itemVIew.findViewById(R.id.imageView_rowIconText_icon);
            text = itemVIew.findViewById(R.id.textView_rowIconText_text);
        }
    }
}