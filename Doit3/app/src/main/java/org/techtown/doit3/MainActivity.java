package org.techtown.doit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ImageView upimage;
    ImageView downimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      findViewById(R.id.down).setOnClickListener(mlistener);
      findViewById(R.id.up).setOnClickListener(mlistener);
        upimage=findViewById(R.id.imageview1);
        downimage=findViewById(R.id.imageview2);

    }

    View.OnClickListener mlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.up:
                    upimage.setImageResource(R.drawable.cute5);
                    downimage.setImageResource(0);
                    break;

                case R.id.down:
                    upimage.setImageResource(0);
                    downimage.setImageResource(R.drawable.cute5);
                    break;
            }

        }
    };
}
