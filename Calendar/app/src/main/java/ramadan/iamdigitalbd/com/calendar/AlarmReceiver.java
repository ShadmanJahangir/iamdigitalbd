package ramadan.iamdigitalbd.com.calendar;

/**
 * Created by Wolverine on 1/29/2015.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    private static final int MY_NOTIFICATION_ID = 1;
    NotificationManager notificationManager;
    Notification myNotification;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm received!", Toast.LENGTH_LONG).show();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("Event Name");
        String location = bundle.getString("Event Location");

        Intent myIntent = new Intent();
        myIntent.setClass(context, MyCalendarActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        myNotification = new NotificationCompat.Builder(context)
                .setContentTitle("Ramadan Event Today")
                .setContentText("Event: " + name + " To " + location)
                .setTicker("Today")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.splash_1)
                .build();

        notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(MY_NOTIFICATION_ID, myNotification);



    }
}