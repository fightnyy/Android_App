package org.techtown.doit13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_name;
    EditText et_birthday;
    EditText et_phone;


    TextView customer_num;

    CustomerAdapter adapter;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_name = findViewById(R.id.et_name);
        et_birthday = findViewById(R.id.et_birthday);
        et_phone = findViewById(R.id.et_phone);


        findViewById(R.id.btn_add).setOnClickListener(listener);


        adapter = new CustomerAdapter();
        customer_num=findViewById(R.id.customer_num);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Customer c = new Customer(et_name.getText().toString(), et_birthday.getText().toString(), et_phone.getText().toString());

            switch (v.getId()) {
                case R.id.btn_add:
                    adapter.addItem(c);
                    customer_num.setText(adapter.getItemCount()+"명");
                    reset();
                    break;
            }
        }
    };

    void reset()
    {
        et_name.setText("");
        et_birthday.setText("");
        et_phone.setText("");
    }
}
