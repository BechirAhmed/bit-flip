package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.bitflip.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {
    @Bind(R.id.categoryList) ListView mCategoryList;
    private String[] mCategoryArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        Resources res = getResources();

        mCategoryArray = res.getStringArray(R.array.categories);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mCategoryArray);
        mCategoryList.setAdapter(adapter);
        mCategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CategoryActivity.this, "You Picked A Category!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
