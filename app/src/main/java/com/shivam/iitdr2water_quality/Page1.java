package com.shivam.iitdr2water_quality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Page1 extends AppCompatActivity {

    public static ArrayList<swimmingpools> pools=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        pools.add(new swimmingpools("SWIM1","ABC",4,30,7,5,70,50));
        pools.add(new swimmingpools("SWIM2","DEF",6,40,7,5,70,50));
        pools.add(new swimmingpools("SWIM3","GHI",6.5,50,7,5,70,50));
        pools.add(new swimmingpools("SWIM4","JKL",5,60,7,5,70,50));


        recyclerView=findViewById(R.id.recycleview);
        Adaptor adaptor=new Adaptor(Page1.this,pools);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

        startService(new Intent(getBaseContext(), Services.class));
    }
}
