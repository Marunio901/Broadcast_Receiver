package com.example.patryko.broadcast_receiver;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Patryko on 12/5/2017.
 */

public class MyNotify extends IntentService{

    private static final String ACTION_NOTIFY = "com.example.patryko.broadcast_receiver.NOTIFY";

    private static final String EXTRA_MESSAGE = "com.example.patryko.broadcast_receiver.MESSAGE";

    public MyNotify() {
        super("MyNotify");
    }

    public static void startActionNotify(Context context, String message) {
        Intent intent = new Intent(context, MyNotify.class);
        intent.setAction(ACTION_NOTIFY);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.startService(intent);


    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_NOTIFY.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_MESSAGE);
                handleActionNotify(param1);
            }
        }
    }


    private void handleActionNotify(String message) {
// The id of the channel.
        //  String CHANNEL_ID = "my_channel_01";
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.mobile); mBuilder.setContentTitle("My notification");
        mBuilder.setContentText(message);
// Creates an explicit intent for an Activity in your app
        Intent i = new Intent(this, MyNotify.class);

        int index = 1;
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MyNotify.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(i);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(index, mBuilder.build());
    }
}

