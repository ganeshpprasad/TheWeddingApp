package com.example.ganesh.brokerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForumActivity extends AppCompatActivity {

    Button create_event_btn;
    TextView event_name_tv;

    String event_name_str;

    public static final String EVENT_NAME = "Event Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        Toolbar toolbar = (Toolbar) findViewById(R.id.forum_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        event_name_tv = (TextView) findViewById(R.id.event_name);
        event_name_str = event_name_tv.getText().toString();

        create_event_btn = (Button) findViewById(R.id.button_create_event);
        create_event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this , UserAccountActivity.class);

                intent.putExtra(EVENT_NAME , event_name_str);

                startActivity(intent);
            }
        });
    }
}
