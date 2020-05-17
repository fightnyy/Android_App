package org.techtown.mobilework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static boolean stop=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startButton).setOnClickListener(mlistener);
        findViewById(R.id.stop).setOnClickListener(mlistener);

    }

    View.OnClickListener mlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           int id =v.getId();
           switch (id){
              case R.id.startButton:
                  stop=false;
                  Log.e("click","click"+stop);
                  Intent intent=new Intent(getApplicationContext(),AnimationService.class);
                  MyGLSurfaceView glView=findViewById(R.id.glView);
                  intent.putExtra("ValueMessenger",glView.getAngleReceiver());
                  intent.putExtra("StartValue",0.0f);
                  intent.putExtra("EndValue",360.0f);
                  intent.putExtra("IncValue",1.0f);
                  intent.putExtra("UpdateTime",10.0f);
                  startService(intent);
                  break;

               case R.id.stop:
                   stop=true;



           }
        }
    };



}
