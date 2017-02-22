package com.example.sergio.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{



    private Context context;
    private Activity activity;

    private ImageButton cartButton;
    private ImageButton shopButton;
    private ImageButton onSaleButton;
    private ImageButton historyButton;
    private ImageButton searchButton;
    private ImageButton logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;
        Intent intent = getIntent();
        String[] data= intent.getStringArrayExtra("data");
        Toast.makeText(context,getString(R.string.welcome)+ " " + data[0] ,Toast.LENGTH_LONG).show();

        cartButton = (ImageButton)findViewById(R.id.cartButton);
        shopButton = (ImageButton)findViewById(R.id.shopButton);
        onSaleButton = (ImageButton)findViewById(R.id.onSaleButton);

        historyButton = (ImageButton)findViewById(R.id.historyButton);
        searchButton = (ImageButton)findViewById(R.id.searchButton);
        logOutButton = (ImageButton)findViewById(R.id.logOutButton);

        cartButton.setOnClickListener(this);
        shopButton.setOnClickListener(this);
        onSaleButton.setOnClickListener(this);

        historyButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        logOutButton.setOnClickListener(this);

    }


    public void buttonClick(View view){
        if(view.getId()==cartButton.getId()){
            Intent intent = new Intent(context,CartActivity.class);
            startActivity(intent);
        }else if(view.getId()==shopButton.getId()){
            Intent intent = new Intent(context,ShopActivity.class);
            startActivity(intent);
        }else if(view.getId()==onSaleButton.getId()){
            Intent intent = new Intent(context,OnSaleActivity.class);
            startActivity(intent);
        }else if(view.getId()==historyButton.getId()){
            Intent intent = new Intent(context,HistoryActivity.class);
            startActivity(intent);
        }else if(view.getId()==searchButton.getId()){
            Intent intent = new Intent(context,SearchActivity.class);
            startActivity(intent);
        }else if(view.getId()== logOutButton.getId()){
            Intent intent = new Intent(context,MainActivity.class);
            Toast.makeText(context,getString(R.string.welcome),Toast.LENGTH_LONG).show();
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v){
        buttonClick(v);
    }
}
