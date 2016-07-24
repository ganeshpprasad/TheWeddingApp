package com.example.ganesh.brokerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.interfaces.OnRecyclerListHomeFragmentInteractionListener;
import com.example.ganesh.brokerapp.R;

public class HomeItemEventRecyclerViewAdapter extends RecyclerView.Adapter<HomeItemEventRecyclerViewAdapter.ViewHolder> {

    private final ListContent.Item[] mValues;
    private final OnRecyclerListHomeFragmentInteractionListener mListener;

    public final static String MY_ITEM_TAG = " My Item View adapter ";

    public HomeItemEventRecyclerViewAdapter(ListContent.Item[] items, OnRecyclerListHomeFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues[position];

//        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues[position].name);
        holder.mImageView.setImageResource(mValues[position].details);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.OnRecyclerListHomeFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
//        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public ListContent.Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView) view.findViewById(R.id.thumb);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
