package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganesh.brokerapp.List.ListContent.Item;
import com.example.ganesh.brokerapp.adapter.MyItemRecyclerViewAdapter;
import com.example.ganesh.brokerapp.interfaces.OnListFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TrendFragment extends Fragment {

    public final static String HOME_FRAGMENT = "EXPLORE_FRAG";

    public static final List<Item> items = new ArrayList<>();

    public void fillList(){
        Log.d(HOME_FRAGMENT , "Inside fill List method");
        items.add(new Item("01", "warrior ", R.drawable.tom2));
        items.add(new Item("02" , "Bane " , R.drawable.tom1));
        items.add(new Item("03" , "Mad Max " , R.drawable.tom3));
    }

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TrendFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TrendFragment newInstance() {
        TrendFragment fragment = new TrendFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(items , mListener));
            Log.d(HOME_FRAGMENT, " OnCreateView method ");
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
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
