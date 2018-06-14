package com.shivam.iitdr2water_quality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Page1 extends AppCompatActivity {

    ArrayList<swimmingpools> pools=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        pools.add(new swimmingpools("RAHUL","utdrcvbulvhxcvhv",8,58,10,5,100,20));
        pools.add(new swimmingpools("RAHUL","utdrcvbulvhxcvhv",20,58,10,5,100,20));


        recyclerView=findViewById(R.id.recycleview);
        Adaptor adaptor=new Adaptor(Page1.this,pools);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
    }
}
