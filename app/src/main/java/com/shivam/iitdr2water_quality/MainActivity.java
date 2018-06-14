package com.shivam.iitdr2water_quality;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.morphingbutton.MorphingButton;

public class MainActivity extends AppCompatActivity {

    EditText Edit_userid;
    EditText Edit_password;
    MorphingButton btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit_userid=findViewById(R.id.Edittext_userid);
        Edit_password=findViewById(R.id.Edittext_password);
        btn_Login=findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MorphingButton.Params circle = MorphingButton.Params.create()
                        .duration(1000);
                btn_Login.morph(circle);

                final Handler handler = new Handler();
                final Runnable r = new Runnable() {
                    public void run() {
                        Intent i=new Intent(MainActivity.this,Page1.class);
                        startActivity(i);
                        finish();
                    }
                };handler.postDelayed(r, 1100);
            }
        });
    }
}
