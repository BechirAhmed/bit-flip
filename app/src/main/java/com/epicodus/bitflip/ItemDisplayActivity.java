package com.epicodus.bitflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemDisplayActivity extends AppCompatActivity {
    @Bind(R.id.itemName) TextView mItemName;
    @Bind(R.id.itemDescription) TextView mItemDescription;
    @Bind(R.id.itemPrice) TextView mItemPrice;
    @Bind(R.id.userName) TextView mUserName;
    @Bind(R.id.userPhone) TextView mUserPhone;
    @Bind(R.id.userEmail) TextView mUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        ButterKnife.bind(this);
    }
}
