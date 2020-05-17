package org.techtown.mobilework;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import static org.techtown.mobilework.MainActivity.stop;


public class AnimationService extends IntentService {

    public AnimationService() {
        super("AnimationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Messenger valMessenger=(Messenger)intent.getExtras().get("ValueMessenger");
        float startAngle=intent.getFloatExtra("StartValue",0);
        float endAngle=intent.getFloatExtra("EndValue",0);
        float incAngle=intent.getFloatExtra("IncValue",0);
        float stepTime=intent.getFloatExtra("UpdateTime",10);

        while(startAngle<endAngle)
        {
            Message msg=Message.obtain();
            msg.obj=new Float(startAngle);
            try{
                valMessenger.send(msg);
                Thread.sleep((long)stepTime);
            }catch (Exception e){}
            if(stop==false)
            startAngle+=incAngle;
            else {
                startAngle += 0;
            }
        }

    }



}
