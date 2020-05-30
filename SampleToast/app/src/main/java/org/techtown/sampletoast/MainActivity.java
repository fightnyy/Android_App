package org.techtown.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButton2Clicked(View v)
    {
        LayoutInflater inflater=getLayoutInflater();

        View layout=inflater.inflate(R.layout.toastborder,(ViewGroup)findViewById(R.id.toast_layout_root));
    }
}
