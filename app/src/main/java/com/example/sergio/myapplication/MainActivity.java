package com.example.sergio.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context context;
    private Activity activity;

    private EditText textEmail;
    private EditText textPassword;
    private TextView labelSignUp;
    private Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //That is how we make something work
        try{
            Intent intent = getIntent();
            Gson gson = new Gson();

            Log.e("DATABASE", "Succesful :)");
        }catch (Exception e) {

        }
            textEmail = (EditText) findViewById(R.id.textEmail);
        textPassword = (EditText) findViewById(R.id.textPassword);
        labelSignUp = (TextView) findViewById(R.id.labelSignUp);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);

        context = this;
        activity = this;

        buttonLogin.setOnClickListener(this);
        labelSignUp.setOnClickListener(this);

    }

    public void loginClick(View view){
        String email = textEmail.getText().toString();
        String pass = textPassword.getText().toString();
        if(email.isEmpty()){
            Toast.makeText(context,getString(R.string.error1),
                    Toast.LENGTH_LONG).show();
        }else if (pass.isEmpty()){
            Toast.makeText(context,getString(R.string.error2),
                    Toast.LENGTH_LONG).show();
        }else if(!email.contains("@") && !email.contains(".")){
            Toast.makeText(context,"Invalid E-mail",
                    Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(context,MenuActivity.class);
            String[] data = new String[]{textEmail.getText().toString(),
                    textPassword.getText().toString()};
            intent.putExtra("data",data);
            textEmail.setText("");
            textPassword.setText("");
            startActivity(intent);
        }
    }
    public void signUpClick(View view){
        Intent intent2 = new Intent(context, SignUpActivity.class);
        startActivity(intent2);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == buttonLogin.getId()){
            loginClick(v);
        }else if(v.getId() == labelSignUp.getId()){
            signUpClick(v);
            Log.e("ACTV", "SU working");
        }

    }
}
