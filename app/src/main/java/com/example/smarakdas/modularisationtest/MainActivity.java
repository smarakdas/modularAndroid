package com.example.smarakdas.modularisationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.logicmodule.PeriodicService;
import com.example.testmodule.Sum;
import com.example.testmodule.TestActivity;
import com.example.uimodule.UIActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    private String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Sum sum = new Sum();
                Log.v(TAG,"sum :" + sum.add(3,4));
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });


        startService(new Intent(this,PeriodicService.class));
        startActivity(new Intent(this,UIActivity.class));



    }
}
