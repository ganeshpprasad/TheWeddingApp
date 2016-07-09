package com.example.ganesh.brokerapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ganesh.brokerapp.utils.SessionManager;

public class Splash extends AppCompatActivity {

    public static final String IS_LOGIN = " Is login ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SessionManager manager = new SessionManager();
        Boolean is_login = manager.getPreferences(this , IS_LOGIN );

        if( is_login ) {

            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);

        } else {

            Intent intent = new Intent( this , LoginActivity.class );
            startActivity(intent);

        }

    }
}
