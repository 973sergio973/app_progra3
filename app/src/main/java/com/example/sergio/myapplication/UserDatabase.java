package com.example.sergio.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sergio on 28-Feb-17.
 */

public class UserDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERS.DB";
    private static final int DATABASE_VERSION = 1;



    public UserDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.w("DATABASE","DATABASE CREATED");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.getCreateQuery());
        Log.w("DATABASE","TABLE CREATED");

    }

    public void addUser(String name, String surname, String email, String pass, SQLiteDatabase db){


        ContentValues contentValues = new ContentValues();
        contentValues.put(User.USER_NAME, name);
        contentValues.put(User.USER_SURNAME, surname);
        contentValues.put(User.USER_EMAIL, email);
        contentValues.put(User.USER_PASSWORD, pass);

        db.insert(User.TABLE_NAME, null, contentValues);
        Log.w("DATABASE","DATA INSERTED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        // Creating tables again
        onCreate(db);

    }
}
