package com.andridlearning.amit_gupta.broadcastrecieverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Amit_Gupta on 8/31/15.
 */
public class MyPendingIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("MSG!");
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }
}
