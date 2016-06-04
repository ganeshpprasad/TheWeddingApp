package com.example.ganesh.brokerapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.List.ListContent;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a  and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemLinearRecyclerViewAdapter extends RecyclerView.Adapter<MyItemLinearRecyclerViewAdapter.ViewHolder> {

    private final List<ListContent.Item> mValues;
    private final OnListInteractionListener mListener;

    public MyItemLinearRecyclerViewAdapter(List<ListContent.Item> items, OnListInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_explore_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mCategoryName.setText(holder.mItem.name);
        holder.mImageView.setImageResource(holder.mItem.details);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListInteraction(holder.mCategoryName.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mCategoryName;

        public ListContent.Item mItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.category_card_iv);
            mCategoryName = (TextView) itemView.findViewById(R.id.category_card_tv);
        }
    }
}
