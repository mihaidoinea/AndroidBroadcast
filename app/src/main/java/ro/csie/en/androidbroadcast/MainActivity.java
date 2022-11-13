package ro.csie.en.androidbroadcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageReceiver messageReceiver = new MessageReceiver();
        IntentFilter intentFilter = new IntentFilter("ase.ism.mas.CUSTOM_INTENT");
        registerReceiver(messageReceiver, intentFilter);

        SMSReceiver smsReceiver = new SMSReceiver();
        IntentFilter smsIntentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsReceiver, smsIntentFilter);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100)
        {
            Log.d(TAG, "Permission result received");
        }
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("msg","Hello ISM!");
        intent.setAction("ase.ism.mas.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}