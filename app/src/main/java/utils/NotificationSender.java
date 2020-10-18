package utils;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import com.example.withouthearing.R;

import java.util.Calendar;

public class NotificationSender {

    static int idNotification = 1;
    static String idChannel = "NOTIFICATION CHANNEL";

    public static void sendNotification(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), NotificationPublisher.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context.getApplicationContext(),
                0,
                intent,
                0);

        String titleNotification = "Tap open";
        String descriptionNotification = "KITCHEN";

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), idChannel)
                        .setSmallIcon(R.drawable.icon_notification)
                        .setContentTitle(titleNotification)
                        .setContentText(descriptionNotification)
                        .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context.getApplicationContext());
        notificationManager.notify(idNotification, notificationBuilder.build());
    }

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "NOTIFICATION CHANNEL";
            String description = "NOTIFICATION CHANNEL DESCRIPTION";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel("NOTIFICATION CHANNEL", name, importance);
            channel.setDescription(description);
            channel.setLightColor(Color.BLUE);
            channel.setVibrationPattern(new long[] {0, 1000, 500, 1000});
            channel.enableVibration(true);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
