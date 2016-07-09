package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ganesh.brokerapp.R;

public class CreateEventCityFragment extends Fragment {

    private OnCreateEventCityFragmentInteractionListener mListener;

    public CreateEventCityFragment() {
        // Required empty public constructor
    }

    public static CreateEventCityFragment newInstance() {
        CreateEventCityFragment fragment = new CreateEventCityFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_event_city, container, false);

        Button next_btn = (Button) view.findViewById(R.id.next_city_create_event_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations();
                fragmentTransaction.replace(R.id.create_event_container ,
                        ReviewAndSaveFragment.newInstance() ).addToBackStack(null).commit();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCreateEventCityFragmentInteractionListener) {
            mListener = (OnCreateEventCityFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCreateEventCityFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCreateEventCityFragmentInteraction(Uri uri);
    }
}
