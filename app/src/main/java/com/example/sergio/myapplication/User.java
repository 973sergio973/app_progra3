package com.example.sergio.myapplication;

/**
 * Created by Sergio on 28-Feb-17.
 */

public class User {
        public static final String USER_NAME = "USER_NAME";
        public static final String USER_SURNAME = "USER_SURNAME";
        public static final String USER_EMAIL = "USER_EMAIL";
        public static final String USER_PASSWORD = "USER_PASSWORD";
        public static final String TABLE_NAME = "user_info";

        private static final String CREATE_QUERY =
                "CREATE TABLE " + User.TABLE_NAME + "(" + User.USER_NAME +
                        " TEXT," + User.USER_SURNAME + " TEXT," +
                        User.USER_EMAIL + " TEXT," + User.USER_PASSWORD + " TEXT);";

        public static String getCreateQuery() {
                return CREATE_QUERY;
        }

}
