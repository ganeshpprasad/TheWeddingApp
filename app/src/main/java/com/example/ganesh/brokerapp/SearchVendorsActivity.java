package com.example.ganesh.brokerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.List.ListContent;

import java.util.ArrayList;
import java.util.List;

public class SearchVendorsActivity extends AppCompatActivity {

    public static final String LOG_TAG_SVA = "Search vendor activity";

    public static final List<ListContent.Item> items = new ArrayList<>();

    public void fillList(){
        items.add(new ListContent.Item("01", "Warrior ", R.drawable.tom1));
        items.add(new ListContent.Item("02" , "Bane " , R.drawable.tom2));
        items.add(new ListContent.Item("03" , "Mad Max " , R.drawable.tom3));
    }

    public SearchVendorsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vendors);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_vendors_toolbar);
//        assert toolbar != null;
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fillList();

        RecyclerView rv = (RecyclerView) findViewById(R.id.category_list_rv);
        assert rv != null;
        Context context = rv.getContext();
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new AdapterForCategory(items));

    }

    private class AdapterForCategory extends RecyclerView.Adapter<AdapterForCategory.ViewHolder>{

        List<ListContent.Item> items;

        public AdapterForCategory(List<ListContent.Item> _items) {
            items = _items;
        }

        @Override
        public AdapterForCategory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search_page_cards , parent , false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(AdapterForCategory.ViewHolder holder, int position) {

            holder.mItem = items.get(position);

            holder.mCategoryName.setText(holder.mItem.name);
            holder.mImageView.setImageResource(holder.mItem.details);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SearchVendorsActivity.this , CategoryMainActivity.class);
                    //TODO send extra ... the name
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_create_or_join , menu);
        return true;
    }

}
