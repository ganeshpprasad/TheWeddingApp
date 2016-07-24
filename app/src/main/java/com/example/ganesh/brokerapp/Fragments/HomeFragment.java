package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganesh.brokerapp.List.*;
import com.example.ganesh.brokerapp.List.ListContent.Item;
import com.example.ganesh.brokerapp.adapter.HomeItemEventRecyclerViewAdapter;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListHomeFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;

public class HomeFragment extends Fragment {

    private OnRecyclerListHomeFragmentInteractionListener mListener;

    public static final ListContent.Item[] items = new ListContent.Item[] {
            new Item("01", " Ashok Kumar's event ", R.drawable.image4) ,
            new Item("02" , " Jon Doe's event " , R.drawable.image2) ,
            new Item("03" , " Mary Jane's event " , R.drawable.image3)
    };

    public HomeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
            recyclerView.setAdapter(new HomeItemEventRecyclerViewAdapter(items , mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecyclerListHomeFragmentInteractionListener) {
            mListener = (OnRecyclerListHomeFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
