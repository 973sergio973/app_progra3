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
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private Context context;
    private Activity activity;
    private UserDatabase userDatabase;
    private SQLiteDatabase sqLiteDatabase;


    private EditText textName, textSurname, textEmail, textPassword, textVerifyPassword;
    Button buttonSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textName = (EditText)findViewById(R.id.textName);
        textSurname = (EditText)findViewById(R.id.textSurname);
        textEmail = (EditText)findViewById(R.id.textEmailSU);
        textPassword = (EditText)findViewById(R.id.textPasswordSU);
        textVerifyPassword = (EditText)findViewById(R.id.textPasswordSUR);
        buttonSignUp = (Button)findViewById(R.id.buttonSignUp);

        context = this;
        activity = this;

        buttonSignUp.setOnClickListener(this);

    }
    public void addUser() {

        String name = textName.getText().toString();
        String surname = textSurname.getText().toString();
        String email = textEmail.getText().toString();
        String pass = textPassword.getText().toString();
        String ver = textVerifyPassword.getText().toString();


        if(name.isEmpty()){
            Toast.makeText(context,"Enter your name.",
                    Toast.LENGTH_LONG).show();
        }else if(surname.isEmpty()){
            Toast.makeText(context,"Enter your surname.",
                    Toast.LENGTH_LONG).show();
        }else if(email.isEmpty()){
            Toast.makeText(context,getString(R.string.error1),
                    Toast.LENGTH_LONG).show();
        }else if (pass.isEmpty()){
            Toast.makeText(context,getString(R.string.error2),
                    Toast.LENGTH_LONG).show();
        }else if(!email.contains("@") && !email.contains(".")){
            Toast.makeText(context,"Invalid E-mail",
                    Toast.LENGTH_LONG).show();
        /*}else if(pass != ver){
            Toast.makeText(context,"Password MUST be the same in both fields.",
                    Toast.LENGTH_LONG).show();*/
        }else{
            userDatabase = new UserDatabase(context);
            sqLiteDatabase = userDatabase.getWritableDatabase();
            userDatabase.addUser(name,surname,email,pass,sqLiteDatabase);
            userDatabase.close();
            Intent intent = new Intent(context, MainActivity.class);
            final Gson gson = new Gson();
            intent.putExtra("DB", gson.toJson(userDatabase));
            startActivity(intent);



        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == buttonSignUp.getId()){
            addUser();
        }
    }
}
