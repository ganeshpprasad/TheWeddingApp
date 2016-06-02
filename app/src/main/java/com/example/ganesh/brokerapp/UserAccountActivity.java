package com.example.ganesh.brokerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class UserAccountActivity extends AppCompatActivity {

    Button done_btn_acc;

    public static final String ACCOUNT_OK = " account valid ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        assert toolbar != null;

        done_btn_acc = (Button) findViewById(R.id.done_btn_acc);

        done_btn_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAccountActivity.this , MainActivity.class);

                intent.putExtra(ACCOUNT_OK , true);

                //TODO A lot i mean a lot you gotta take user name and update navigation view based user profile change configs and shit

                startActivity(intent);
            }
        });

    }
}
