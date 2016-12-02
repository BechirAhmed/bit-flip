package com.epicodus.bitflip;

import android.content.Intent;
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
    @Bind(R.id.userEmail) TextView mUserEmail;
    @Bind(R.id.userPhone) TextView mUserPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("itemName");
        String itemDescription = intent.getStringExtra("itemDescription");
        int itemPrice = Integer.parseInt(intent.getStringExtra("itemPrice"));
        String userName = intent.getStringExtra("userName");
        String userEmail = intent.getStringExtra("userEmail");
        String userPhone = intent.getStringExtra("userPhone");

        mItemName.setText(itemName);
        mItemDescription.setText(itemDescription);
        mItemPrice.setText("$" + itemPrice);
        mUserName.setText(userName);
        mUserEmail.setText(userEmail);
        mUserPhone.setText(userPhone);
    }
}
