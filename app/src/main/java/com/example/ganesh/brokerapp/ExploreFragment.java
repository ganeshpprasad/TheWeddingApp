package com.example.ganesh.brokerapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.List.ListContent.Item;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    public final static String EXPLORE_FRAGMENT = "EXPLORE_FRAG";

    private OnListInteractionListener mListener;

    public ExploreFragment() {
    }

    public static final List<ListContent.Item> items = new ArrayList<>();

    public void fillList(){
        items.add(new ListContent.Item("01", "Photography ", R.drawable.tom1));
        items.add(new ListContent.Item("02" , "Catering " , R.drawable.tom2));
        items.add(new ListContent.Item("03" , "Halls" , R.drawable.tom3));
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ExploreFragment newInstance() {
        ExploreFragment fragment = new ExploreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyItemLinearRecyclerViewAdapter(items, mListener));
            Log.d(EXPLORE_FRAGMENT, " OnCreateView method ");
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
