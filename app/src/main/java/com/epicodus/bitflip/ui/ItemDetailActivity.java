package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.bitflip.R;
import com.epicodus.bitflip.model.Item;
import com.google.firebase.database.ThrowOnExtraProperties;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemDetailActivity extends AppCompatActivity {
    @Bind(R.id.itemNameTextView) TextView mItemNameTextView;
    @Bind(R.id.itemCategoryTextView) TextView mItemCategoryTextView;
    @Bind(R.id.itemDescriptionTextView) TextView mItemDescriptionTextView;
    @Bind(R.id.itemPriceTextView) TextView mItemPriceTextView;
    @Bind(R.id.ownerTextView) TextView mOwnerTextView;
    @Bind(R.id.emailTextView) TextView mEmailTextView;
    @Bind(R.id.emailOwnerButton) Button mEmailOwnerButton;

    private Item mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mItem = Parcels.unwrap(intent.getParcelableExtra("item"));
    }
}
