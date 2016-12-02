package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.bitflip.R;
import com.epicodus.bitflip.model.Item;
import com.epicodus.bitflip.services.WalmartService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ComparePricesActivity extends AppCompatActivity {
    private ArrayList<Item> mCompareItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_prices);

        Intent intent = getIntent();
        String item = intent.getStringExtra("itemName");

        getSimilarItems(item);
    }

    private void getSimilarItems(String item) {
        final WalmartService walmartService = new WalmartService();

        walmartService.findItems(item, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mCompareItems = walmartService.processSearchResults(response);

                ComparePricesActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });
            }
        });
    }
}
