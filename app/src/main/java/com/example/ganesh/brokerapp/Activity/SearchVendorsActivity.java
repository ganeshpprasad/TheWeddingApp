package com.example.ganesh.brokerapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchVendorsActivity extends AppCompatActivity {

    public static final String LOG_TAG_SVA = "Search vendor activity";

    public static final List<ListContent.Item> items = new ArrayList<>();

    public void fillList(){
        items.add(new ListContent.Item("01", " Bridal wear ", R.drawable.image3));
        items.add(new ListContent.Item("02" , " Wedding designers " , R.drawable.image4));
        items.add(new ListContent.Item("03" , " Catering " , R.drawable.image1));
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

//        getSupportFragmentManager().beginTransaction().add(R.id.container_search_activity ,  new ExploreFragment()).commit();


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

        return true;
    }

}
