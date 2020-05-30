package org.techtown.doit4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button send;
    String msg;
    TextView textView;
    int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToast(msg);
            }
        });
        final EditText editText=findViewById(R.id.editText2);
        textView =findViewById(R.id.textView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int leng=editText.getText().toString().length();
                textView.setText(leng+"/ 80");
                Log.d("Tag",start+" "+before+" "+count);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    void startToast(String msg)
    {
        Toast.makeText(this,"",Toast.LENGTH_LONG).show();
    }
}
