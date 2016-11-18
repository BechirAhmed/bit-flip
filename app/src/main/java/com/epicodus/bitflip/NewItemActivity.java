package com.epicodus.bitflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewItemActivity extends AppCompatActivity {
    @Bind(R.id.newItemDescription) EditText mNewItemDescription;
    @Bind(R.id.newItemName) EditText mNewItemName;
    @Bind(R.id.newItemPrice) EditText mNewItemPrice;
    @Bind(R.id.inputName) EditText mInputName;
    @Bind(R.id.inputEmail) EditText mInputEmail;
    @Bind(R.id.inputPhone) EditText mInputPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        ButterKnife.bind(this);
    }
}
