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

import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.List.ListContent.Item;
import com.example.ganesh.brokerapp.adapter.HomeItemEventRecyclerViewAdapter;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListHomeFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnRecyclerListHomeFragmentInteractionListener}
 * interface.
 */
public class TrendFragment extends Fragment {

    public final static String HOME_FRAGMENT = "EXPLORE_FRAG";

    public static final ListContent.Item[] items = new ListContent.Item[] {
            new Item("01", " Ashok Kumar's event ", R.drawable.image4) ,
            new Item("02" , " Jon Doe's event " , R.drawable.image2) ,
            new Item("03" , " Mary Jane's event " , R.drawable.image3)
    };

    private OnRecyclerListHomeFragmentInteractionListener mListener;

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
            Log.d(HOME_FRAGMENT, " OnCreateView method ");
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
