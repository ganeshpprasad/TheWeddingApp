package com.example.ganesh.brokerapp.Activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ganesh.brokerapp.R;


public class SearchVendorsActivity extends AppCompatActivity {

//    public static final String LOG_TAG = "SearchVendor activity";

    public SearchVendorsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vendors);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_vendors_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle( "Search Vendors" );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_vendor_search , menu );

        MenuItem searchItem = menu.findItem(R.id.search_vendor);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView( searchItem );
        searchView.setQueryHint("Search Vendors");
        searchView.setIconified(false);
        searchView.setIconifiedByDefault(true);

        return true;
    }
}
