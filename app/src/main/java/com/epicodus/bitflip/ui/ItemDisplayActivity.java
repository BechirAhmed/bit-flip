package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.epicodus.bitflip.R;
import com.epicodus.bitflip.model.Item;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemDisplayActivity extends AppCompatActivity implements View.OnClickListener {
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

//        Intent intent = getIntent();
//        Item item = (Item) Parcels.unwrap(getIntent().getParcelableExtra("item"));
//        String userName = intent.getStringExtra("userName");
//        String userEmail = intent.getStringExtra("userEmail");
//        String userPhone = intent.getStringExtra("userPhone");
//
//        mItemName.setText(item.getName());
//        mItemDescription.setText(item.getDescription());
//        mItemPrice.setText("$" + item.getPrice());
//        mUserName.setText(userName);
//        mUserEmail.setText(userEmail);
//        mUserPhone.setText(userPhone);

        mUserEmail.setOnClickListener(this);
        mUserPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mUserPhone) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mUserPhone.getText()));
            startActivity(phoneIntent);
        }
    }
}
