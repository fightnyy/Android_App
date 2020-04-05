package com.example.simpletouch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onColorButtonClick(View v){
        Singletouchview single =findViewById(R.id.singleTouchView);

        switch (v.getId()){
            case R.id.btn_black:
                single.setColor(Color.BLACK);
                break;
            case R.id.btn_green:
                single.setColor(Color.GREEN);
                break;
            case R.id.btn_red:
                single.setColor(Color.RED);
                break;
            case R.id.btn_clear:
                single.clearPath();
                break;
        }
    }
}
