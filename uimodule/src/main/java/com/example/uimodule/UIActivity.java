package com.example.uimodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.logicmodule.PeriodicService;
import com.example.logicmodule.SingletonDataClass;

public class UIActivity extends AppCompatActivity {

    TextView textView;
    private String TAG ="UIActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        SingletonDataClass singletonDataClass = SingletonDataClass.getInstance();

        textView = findViewById(R.id.textView);

         singletonDataClass.getLiveData().observe(this, integer->{

             Log.v(TAG,"integer :"  +integer);
         if(integer==null)return;

         textView.setText(""+integer);
        });

    }
}
