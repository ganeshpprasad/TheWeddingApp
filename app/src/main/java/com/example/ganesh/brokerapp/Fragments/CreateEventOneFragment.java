package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.ganesh.brokerapp.R;

public class CreateEventOneFragment extends Fragment implements View.OnClickListener {

    private OnCreateEventOneFragmentInteractionListener mListener;

    public CreateEventOneFragment() {
        // Required empty public constructor
    }

    public static CreateEventOneFragment newInstance() {
        CreateEventOneFragment fragment = new CreateEventOneFragment();
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
        View rootView =  inflater.inflate(R.layout.fragment_create_event_one, container, false);


//        Spinner implementation
        Spinner spinner = (Spinner) rootView.findViewById(R.id.event_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.events_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button next_one = (Button) rootView.findViewById(R.id.next_one_create_event_btn);
        next_one.setOnClickListener( this );

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCreateEventOneFragmentInteractionListener) {
            mListener = (OnCreateEventOneFragmentInteractionListener) context;
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

    @Override
    public void onClick(View v) {
        mListener.onCreateEventOneFragmentInteraction();
    }

    public interface OnCreateEventOneFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCreateEventOneFragmentInteraction();
    }
}
