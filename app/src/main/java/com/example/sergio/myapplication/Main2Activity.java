package com.example.sergio.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    private Context context;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;
        Intent intent = getIntent();
        String[] data= intent.getStringArrayExtra("data");
        Toast.makeText(context,getString(R.string.welcome) + data[0] ,Toast.LENGTH_LONG).show();




    }
}
