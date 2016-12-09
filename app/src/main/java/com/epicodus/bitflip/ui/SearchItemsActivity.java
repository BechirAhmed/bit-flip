package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.epicodus.bitflip.R;

import butterknife.Bind;

public class SearchItemsActivity extends AppCompatActivity {
    @Bind(R.id.searchItemsRecyclerView) RecyclerView mSearchItemsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        getItems(query);
    }

    private
}
