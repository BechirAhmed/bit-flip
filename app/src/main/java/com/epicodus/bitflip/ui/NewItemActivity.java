package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.bitflip.Constants;
import com.epicodus.bitflip.model.Item;
import com.epicodus.bitflip.ui.ItemDisplayActivity;
import com.epicodus.bitflip.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewItemActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newItemDescription) EditText mNewItemDescription;
    @Bind(R.id.newItemName) EditText mNewItemName;
    @Bind(R.id.newItemPrice) EditText mNewItemPrice;
    @Bind(R.id.spinnerCategory) Spinner mNewItemCategory;
    @Bind(R.id.inputName) EditText mInputName;
    @Bind(R.id.inputEmail) EditText mInputEmail;
    @Bind(R.id.inputPhone) EditText mInputPhone;
    @Bind(R.id.imageUrlEditText) EditText mImageUrl;
    @Bind(R.id.newItemButton) Button mNewItemButton;
    @Bind(R.id.comparePricesButton) Button mComparePricesButton;
    @Bind(R.id.addCategoryButton) Button mAddCategoryButton;
    private List<String> mCategoryKeyArray = new ArrayList<String>();

    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        ButterKnife.bind(this);

        ref = FirebaseDatabase.getInstance().getReference();

        mNewItemButton.setOnClickListener(this);
        mComparePricesButton.setOnClickListener(this);
        mAddCategoryButton.setOnClickListener(this);

        ref.child(Constants.FIREBASE_CHILD_CATEGORIES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> categories = new ArrayList<String>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String category = snapshot.getValue().toString();
                    String categoryKey = snapshot.getKey().toString();
                    categories.add(category);
                    mCategoryKeyArray.add(categoryKey);
                }

                ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(NewItemActivity.this, android.R.layout.simple_spinner_item, categories);
                mNewItemCategory.setAdapter(categoryAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == mNewItemButton) {
            String newItemCategory = mNewItemCategory.getSelectedItem().toString();
            int categoryIndex = mNewItemCategory.getSelectedItemPosition();
            String newItemDescription = mNewItemDescription.getText().toString();
            String newItemName = mNewItemName.getText().toString();
            String newItemPrice = mNewItemPrice.getText().toString();
            String newItemImageUrl = mImageUrl.getText().toString();
            Item newItem = new Item(newItemCategory, newItemName, newItemDescription, newItemPrice, newItemImageUrl);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            String categoryId = findCategoryId(categoryIndex);
            DatabaseReference categoryRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_CATEGORIES)
                    .child(categoryId);
            DatabaseReference userRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_USERS)
                    .child(uid);
            DatabaseReference userPushRef = userRef.push();
            DatabaseReference categoryPushRef = categoryRef.push();
            String categoryPushId = categoryPushRef.getKey();
            String userPushId = userPushRef.getKey();
            newItem.setUserPushId(userPushId);
            newItem.setCategoryPushId(categoryPushId);
            userPushRef.setValue(newItem);
            categoryPushRef.setValue(newItem);
            Intent intent = new Intent(NewItemActivity.this, ItemDisplayActivity.class);
            saveItemToDatabase(newItem);
            startActivity(intent);
        } else if(v == mComparePricesButton) {
            String newItemName = mNewItemName.getText().toString();
            Intent intent = new Intent(NewItemActivity.this, ComparePricesActivity.class);
            intent.putExtra("itemName", newItemName);
            startActivity(intent);
        } else if(v == mAddCategoryButton) {
            Intent intent = new Intent(NewItemActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }

    private void saveItemToDatabase(Item item) {
        ref.child(Constants.FIREBASE_CHILD_ITEMS).push().setValue(item);
    }

    private String findCategoryId(int index) {
        String categoryKey = mCategoryKeyArray.get(index);
        return categoryKey;
    }

}
