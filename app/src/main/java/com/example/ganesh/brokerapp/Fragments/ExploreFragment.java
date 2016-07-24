package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.adapter.ExploreItemEventRecycleAdapter;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListExploreFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;

public class ExploreFragment extends Fragment {

//    public final static String EXPLORE_FRAGMENT_TAG = "EXPLORE_FRAG";

    private OnRecyclerListExploreFragmentInteractionListener mListener;
    public static final ListContent.Item[] items = new ListContent.Item[]{
            new ListContent.Item("01", "Photography ", R.drawable.img_camera_48px) ,
            new ListContent.Item("02" , "Catering " , R.drawable.img_restaurant_48px) ,
            new ListContent.Item("03" , "Halls" , R.drawable.img_halls_48px) ,
            new ListContent.Item("04" , "Decorators" , R.drawable.img_florist_48px)
    };

    public ExploreFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ExploreFragment newInstance() {
        ExploreFragment fragment = new ExploreFragment( );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context , 2));
            recyclerView.setAdapter(new ExploreItemEventRecycleAdapter(items, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            if (context instanceof OnRecyclerListExploreFragmentInteractionListener) {
                mListener = (OnRecyclerListExploreFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement ");
            }


    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
