package org.techtown.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.techtown.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new PersonAdapter();

        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));
        adapter.addItem(new Person("kim","010-0000-0000"));
        adapter.addItem(new Person("na","010-2222-3333"));
        adapter.addItem(new Person("you","010-2222-4443"));



        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"item is chosen "+ item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
