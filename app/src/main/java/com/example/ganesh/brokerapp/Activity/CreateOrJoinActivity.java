package com.example.ganesh.brokerapp.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;

import com.example.ganesh.brokerapp.Fragments.CreateEventCityFragment;
import com.example.ganesh.brokerapp.Fragments.CreateEventOneFragment;
import com.example.ganesh.brokerapp.R;

import java.util.Calendar;

public class CreateOrJoinActivity extends AppCompatActivity implements
        CreateEventOneFragment.OnCreateEventOneFragmentInteractionListener ,
        CreateEventCityFragment.OnCreateEventCityFragmentInteractionListener{

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_join);

//        Toolbar implementation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About your event");

        getSupportFragmentManager().beginTransaction().add( R.id.create_event_container ,
                CreateEventOneFragment.newInstance() ).commit();

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }


    @Override
    public void onCreateEventOneFragmentInteraction() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations();
        fragmentTransaction.replace(R.id.create_event_container ,
                CreateEventCityFragment.newInstance() ).addToBackStack(null).commit();
    }

    @Override
    public void onCreateEventCityFragmentInteraction(Uri uri) {

    }
}
