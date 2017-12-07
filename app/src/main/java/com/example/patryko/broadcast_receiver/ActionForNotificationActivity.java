package com.example.patryko.broadcast_receiver;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;
import android.widget.TextView;

/**
 * Created by Patryko on 12/4/2017.
 */

public class ActionForNotificationActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_for_notification);
        TextView tv = (TextView)findViewById(R.id.textView2);
        String message = getIntent().getStringExtra("Message");
        tv.setText(message);
    }

}


