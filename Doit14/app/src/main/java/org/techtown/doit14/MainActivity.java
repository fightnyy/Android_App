package org.techtown.doit14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ProductAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter=new ProductAdapter();


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);



        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));adapter.addItem(new Product("123","Tom","10000"));adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));adapter.addItem(new Product("123","Tom","10000"));adapter.addItem(new Product("123","Tom","10000"));
        adapter.addItem(new Product("123","Tom","10000"));



    }


}
