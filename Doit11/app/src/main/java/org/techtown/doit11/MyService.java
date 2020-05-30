package org.techtown.doit11;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent==null)
        {
            return Service.START_STICKY;
        }
        else {
            String str = intent.getStringExtra("str");
            Log.e("tag", str);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //FLAG_ACTIVITY_NEW_TASK는 서비스는 화면이 없으므로 이 플래그를 추가해야 한다
            //FLAG_ACTIVITY_CLEAR_TOP과 FLAG_ACTIVITY_SINGLE_TOP은 이미 
            intent1.putExtra("tag", str);
            startActivity(intent1);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


}
