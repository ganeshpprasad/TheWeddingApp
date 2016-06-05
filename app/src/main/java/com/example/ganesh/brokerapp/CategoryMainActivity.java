package com.example.ganesh.brokerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.List.ListContent;

import java.util.ArrayList;
import java.util.List;

public class CategoryMainActivity extends AppCompatActivity {

    //TODO You gotta change list items

    public static final List<ListContent.Item> items = new ArrayList<>();

    RecyclerView rv;

    public void fillList(){
        items.add(new ListContent.Item("01", "Warrior ", R.drawable.tom1));
        items.add(new ListContent.Item("02" , "Bane " , R.drawable.tom2));
        items.add(new ListContent.Item("03" , "Mad Max " , R.drawable.tom3));
    }

    public CategoryMainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fillList();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = (RecyclerView) findViewById(R.id.category_each_list_rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(new AdapterForCategoryEach(items));

    }

    private class AdapterForCategoryEach extends RecyclerView.Adapter<AdapterForCategoryEach.ViewHolder>{

        List<ListContent.Item> items_adapter;

        public AdapterForCategoryEach(List<ListContent.Item> _items) {
            items_adapter = _items;
        }

        @Override
        public AdapterForCategoryEach.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search_page_cards , parent , false);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mItem = items.get(position);

            holder.mCategoryName.setText(holder.mItem.name);
            holder.mImageView.setImageResource(holder.mItem.details);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CategoryMainActivity.this , VendorAccountActivity.class);
                    //TODO send user detail
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return 3;
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

}
