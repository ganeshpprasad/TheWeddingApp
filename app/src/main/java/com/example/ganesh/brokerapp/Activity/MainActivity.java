package com.example.ganesh.brokerapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ganesh.brokerapp.Fragments.ExploreFragment;
import com.example.ganesh.brokerapp.Fragments.HomeFragment;
import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListHomeFragmentInteractionListener;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListExploreFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;
import com.example.ganesh.brokerapp.Fragments.TrendFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , OnRecyclerListHomeFragmentInteractionListener, OnRecyclerListExploreFragmentInteractionListener {

    //public static final String MAIN_ACT = "MAIN_ACTIVITY";

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewpager;

    public static final String IMAGE_DETAILS = "Image resource id";
    public static final String IMAGE_NAME = "Image name ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewpager = (ViewPager) findViewById(R.id.container);
        if (viewpager != null) {
            viewpager.setAdapter(sectionsPagerAdapter);
            viewpager.setCurrentItem(1);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.lp_tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewpager);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_main);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , CreateOrJoinActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //TODO see profile event

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if ( id == R.id.action_landing_page_search ) {
            //TODO launch the search page ?
        }

        if ( id == R.id.action_landing_page_notification ) {
            //TODO launch notification page ?
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            Intent intent = new Intent(this , SearchVendorsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_events) {
            Intent intent = new Intent(this , UserEventListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_bookmarks) {

        } else if (id == R.id.nav_messages) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Method called after selecting an event in home page
     * @param item refers to the event java object
     */
    @Override
    public void OnRecyclerListHomeFragmentInteraction(ListContent.Item item) {

        Intent intent = new Intent(this , EventDetailsActivity.class );
        intent.putExtra( IMAGE_DETAILS , item.details );
        intent.putExtra( IMAGE_NAME , item.name );

        startActivity(intent);

    }

    public static final String CATEGORY_ID = "category id";

    @Override
    public void OnRecyclerListExploreFragmentInteraction(String text , int id) {

        Intent intent = new Intent(this , CategoryMainActivity.class);
        intent.putExtra("CAT_NAME" , text);
        intent.putExtra( CATEGORY_ID , id );
        startActivity(intent);

    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter{

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0 : return ExploreFragment.newInstance();
                case 1 : return HomeFragment.newInstance();
                case 2 : return TrendFragment.newInstance();
                default : return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0: return "CATEGORY";
                case 1 : return "HOME";
                case 2 : return "TREND";
            }
            return null;
        }
    }

}
