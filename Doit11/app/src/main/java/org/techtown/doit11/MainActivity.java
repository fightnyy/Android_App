package org.techtown.doit11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(mlistener);

        Intent passedIntent=getIntent();
        send(passedIntent);
    }

    View.OnClickListener mlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button:
                    SendToService();
                    break;
            }
        }
    };

    void SendToService()
    {
        String str=editText.getText().toString();
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra("str",str);

        startService(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        send(intent);
        super.onNewIntent(intent);
    }

    public void send(Intent intent)
    {
        String abc=intent.getStringExtra("tag");
        TextView textView=findViewById(R.id.text);
        textView.setText(abc);

    }
}
