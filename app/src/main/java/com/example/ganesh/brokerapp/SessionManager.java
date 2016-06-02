package com.example.ganesh.brokerapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ganesh Prasad on 25-05-2016.
 */
public class SessionManager {

    public static final String SESSION_STRING = " Preferences String ";

    public void setPreferences( Context context , String key , Boolean value ) {

        SharedPreferences.Editor editor = context.getSharedPreferences( SESSION_STRING , context.MODE_PRIVATE ).edit();
        editor.putBoolean( key , value );
        editor.apply();

    }

    public Boolean getPreferences( Context context , String key ) {

        SharedPreferences prefs = context.getSharedPreferences( SESSION_STRING , context.MODE_PRIVATE );
        Boolean value = prefs.getBoolean( key , false );
        return value;

    }

}
