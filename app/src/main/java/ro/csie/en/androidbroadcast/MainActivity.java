package ro.csie.en.androidbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageReceiver messageReceiver = new MessageReceiver();
        IntentFilter intentFilter = new IntentFilter("ase.ism.mas.CUSTOM_INTENT");
        registerReceiver(messageReceiver, intentFilter);

    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("msg","Hello ISM!");
        intent.setAction("ase.ism.mas.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}