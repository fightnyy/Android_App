package org.techtown.samplelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Layout1 layout1=findViewById(R.id.layout1);

        layout1.setImage(R.drawable.ic_launcher_foreground);
        layout1.setName("kim");
        layout1.setMobile("010-5238-0107");
    }
}
