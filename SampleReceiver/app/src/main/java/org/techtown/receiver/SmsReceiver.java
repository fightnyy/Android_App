package org.techtown.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    public static final String TAG="SmsReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"onReceive 메소드 호출됨");

        Bundle bundle=intent.getExtras();
        SmsMessage[] messages=parseSmsMessage(bundle);
        if(messages!=null&&messages.length>0) {
            String sender=messages[0].getOriginatingAddress();//발신자 번호 확인
            Log.i(TAG, "SMS sender :" + sender);

            String contents=messages[0].getMessageBody();//문자 내용 확인
            Log.i(TAG, "SMS contents :" + contents);

            Date recivedDate=new Date(messages[0].getTimestampMillis());//check for Received time
            Log.i(TAG, "SMS received date :" +recivedDate.toString());
        }
    }

    //This Method will be used globally

    private SmsMessage[] parseSmsMessage(Bundle bundle)
    {
        Object[] objs=(Object[])bundle.get("pdus");
        SmsMessage[] messages=new SmsMessage[objs.length];

        int smsCount=objs.length;
        for(int i=0;i<smsCount;i++)
        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                String format=bundle.getString("format");
                messages[i]=SmsMessage.createFromPdu((byte[])objs[i],format);
            }
            else{
                messages[i]=SmsMessage.createFromPdu((byte[])objs[i]);
            }
        }
        return messages;
    }

}
