package ro.csie.en.androidbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras != null)
        {
            Object[] pdus = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for(int i=0; i<smsMessages.length; i++)
            {
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String from = smsMessages[i].getOriginatingAddress();
                String message = smsMessages[i].getMessageBody();
                Toast.makeText(context, "From: " + from + ", message: " + message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
