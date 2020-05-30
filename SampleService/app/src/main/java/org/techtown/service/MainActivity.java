package org.techtown.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                Intent intent= new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command","show");
                intent.putExtra("name",name);

                startService(intent);
            }
        });

        Intent passedIntent=getIntent();
        processIntent(passedIntent);
    }

    protected void onNewIntent(Intent intent)
    {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent)
    {
        if(intent!=null)
        {
            String command=intent.getStringExtra("command");
            String name=intent.getStringExtra("name");
            Toast.makeText(this,command+"  "+name,Toast.LENGTH_SHORT).show();
        }
    }


}
