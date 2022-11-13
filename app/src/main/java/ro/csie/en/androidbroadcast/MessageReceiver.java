package ro.csie.en.androidbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    private static final String TAG = MessageReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Message received!");
        Bundle extras = intent.getExtras();
        String msg = extras.getString("msg");
        Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
