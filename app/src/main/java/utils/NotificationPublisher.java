package utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.withouthearing.HomePageActivity;

public class NotificationPublisher extends BroadcastReceiver {

    NotificationManager notificationManager;
    int idNotification = 1;
    String idChannel = "NOTIFICATION CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        String titleNotification = "Tap open";
        String descriptionNotification = "KITCHEN";

        Intent viewIntent = new Intent(context, HomePageActivity.class);
        viewIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingIntent = PendingIntent.getActivity(context, idNotification, viewIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "NOTIFICATION CHANNEL")
                .setContentIntent(pendingIntent)
                //.setSmallIcon(R.drawable.ic_info)
                .setContentTitle(titleNotification)
                .setContentText(descriptionNotification)
                //.setAutoCancel(true)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                ;

        notificationBuilder.setLocalOnly(true);

        notificationManager.notify(idNotification, notificationBuilder.build());

    }
}
