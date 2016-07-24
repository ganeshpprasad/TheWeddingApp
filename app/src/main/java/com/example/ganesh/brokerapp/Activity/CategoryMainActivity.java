package com.example.ganesh.brokerapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ganesh.brokerapp.Fragments.LandingPagePagerFragment;
import com.example.ganesh.brokerapp.List.ListContent;
import com.example.ganesh.brokerapp.R;

/**
 * Activity launched for each particular vendor type
 * This contains the list of vendors
 *
 */

public class CategoryMainActivity extends AppCompatActivity {

    //TODO You gotta change list items

    //    private static final String CATEGORY_ACTIVTY_TAG = "category_tag";
    RecyclerView rv;
    String actionbarTitle;

    public static final String ITEM_NAME = "item name";
    public static final String ITEM_IMAGE = "item image";
    private static String[] category_list = {"", "Catering", "Halls", "Decorators"};

    ListContent.Item[] items = new ListContent.Item[]{
            new ListContent.Item("01", "Studio Blew ", R.drawable.photo1),
            new ListContent.Item("02", "Studio Purpal ", R.drawable.photo2),
            new ListContent.Item("03", "Studio Read ", R.drawable.photo3),
            new ListContent.Item("03", "Studio Ahrange ", R.drawable.photo4),
            new ListContent.Item("03", "Studio Whyte ", R.drawable.photo5)
    };

    public CategoryMainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_category_main);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        actionbarTitle = intent.getStringExtra("CAT_NAME");
        int id = intent.getIntExtra(MainActivity.CATEGORY_ID, -1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout_category_main);

        if (collapsingToolbarLayout != null) {

            collapsingToolbarLayout.setTitle(actionbarTitle);
            int color = Color.HSVToColor( new float[] { 0f , 0f , 1.f  } );
            collapsingToolbarLayout.setExpandedTitleColor(color);
            collapsingToolbarLayout.setCollapsedTitleTextColor(color);
            collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);

            switch (id) {

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    collapsingToolbarLayout.setBackgroundResource(R.drawable.bg_splash);
            }
        }


        rv = (RecyclerView) findViewById(R.id.category_each_list_rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(new AdapterForCategoryEach(items));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cat_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private class AdapterForCategoryEach extends RecyclerView.Adapter<AdapterForCategoryEach.ViewHolder> {

        ListContent.Item[] items_adapter;

        public AdapterForCategoryEach(ListContent.Item[] _items) {
            items_adapter = _items;
        }

        @Override
        public AdapterForCategoryEach.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search_page_cards, parent, false);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mItem = items[position];

            final int image_resource = holder.mItem.details;
            final String name = holder.mItem.getName();
            holder.mCategoryName.setText(holder.mItem.name);
            holder.mImageView.setImageResource(image_resource);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CategoryMainActivity.this, VendorAccountActivity.class);
                    //TODO send user detail
                    intent.putExtra(ITEM_NAME, name);
                    intent.putExtra(ITEM_IMAGE, image_resource);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return items_adapter.length;
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
