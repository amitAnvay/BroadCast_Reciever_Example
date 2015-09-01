package com.andridlearning.amit_gupta.broadcastrecieverexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class LocalBroacastExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broacast_example);
    }

    private BroadcastReceiver myBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra("message");
            Toast.makeText(LocalBroacastExampleActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcastReceiver, new IntentFilter("my-local-event"));
    }

    public void sendBroadcast(View view){
        Intent i = new Intent("my-local-event");
        i.putExtra("message", "This is a message sent via local Broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
    }

    public void sendBroadcast2(View view){
        Intent i = new Intent(this,MyAppBroadcastReceiver.class); //explictly declared the receiver
        i.putExtra("MSG", "Local Broadcast message");
        sendBroadcast(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_local_broacast_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReceiver);
    }
}
