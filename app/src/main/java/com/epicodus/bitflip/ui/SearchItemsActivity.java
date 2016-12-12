package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epicodus.bitflip.Constants;
import com.epicodus.bitflip.R;
import com.epicodus.bitflip.adapters.FirebaseItemViewHolder;
import com.epicodus.bitflip.model.Item;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchItemsActivity extends AppCompatActivity {
    public static final String TAG = SearchItemsActivity.class.getSimpleName();
    @Bind(R.id.searchItemsRecyclerView) RecyclerView mSearchItemsRecyclerView;

    private DatabaseReference mItemReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String query = intent.getStringExtra("query");

        mItemReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ITEMS);
        setUpFirebaseAdapter(query);

    }


    private void setUpFirebaseAdapter(final String query) {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Item, FirebaseItemViewHolder>(Item.class, R.layout.bitflip_list_item, FirebaseItemViewHolder.class, mItemReference) {
            @Override
            protected void populateViewHolder(FirebaseItemViewHolder viewHolder, Item model, int position) {
                Log.v(TAG, "number" + position);
                if(model.getName().equals(query)) {
                    viewHolder.bindItem(model);
                }
            }
        };
        mSearchItemsRecyclerView.setHasFixedSize(true);
        mSearchItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSearchItemsRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
