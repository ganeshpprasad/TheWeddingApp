package com.example.ganesh.brokerapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.example.ganesh.brokerapp.Activity.CategoryMainActivity;
import com.example.ganesh.brokerapp.R;

public class VendorAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_vendor_desc);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout_vendor_desc);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setImageResource(R.drawable.ic_favorite_black_48px);
                Snackbar.make(view, "You've liked the artist ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String user_name = intent.getStringExtra(CategoryMainActivity.ITEM_NAME);
        int background_resource = intent.getIntExtra(CategoryMainActivity.ITEM_IMAGE , R.drawable.image1) ;

        Drawable background = getResources().getDrawable(background_resource);
        collapsingToolbarLayout.setTitle(user_name);
        collapsingToolbarLayout.setBackground(background);
        int color = Color.HSVToColor( new float[] { 0f , 0f , 1.f  } );
        collapsingToolbarLayout.setExpandedTitleColor(color);
        collapsingToolbarLayout.setCollapsedTitleTextColor(color);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);

    }
}
