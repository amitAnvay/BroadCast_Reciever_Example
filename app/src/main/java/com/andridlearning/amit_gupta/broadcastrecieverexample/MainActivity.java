package com.andridlearning.amit_gupta.broadcastrecieverexample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickLocalBroadCastReceiver(View view){
     Intent i = new Intent(this, LocalBroacastExampleActivity.class);
        startActivity(i);
    }

    public void broadcastPendingIntent(View view){
        String msg = "This is a msg for pending Intent triggerd via Alarm";

        Intent i = new Intent(this, MyPendingIntentReceiver.class);
        i.putExtra("MSG!", msg);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,i,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,(1000 * 3), pendingIntent);

        Toast.makeText(this,"Message would be broadcasted via alarm in 3 sec", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
