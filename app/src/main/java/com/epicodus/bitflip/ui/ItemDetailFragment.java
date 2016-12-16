package com.epicodus.bitflip.ui;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.epicodus.bitflip.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailFragment extends Fragment {
    @Bind(R.id.itemImageView) ImageView mItemImageView;
    private String mImageUrl;

    public static ItemDetailFragment newInstance(String imageUrl) {
        Bundle args = new Bundle();
        ItemDetailFragment fragment = new ItemDetailFragment();
        args.putString("imageUrl", imageUrl);
        fragment.setArguments(args);
        return fragment;
    }
    public ItemDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments().getString("imageUrl");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        ButterKnife.bind(this, view);

        if(!mImageUrl.contains("http")) {
            try {
                Bitmap image = decodeFromBase64(mImageUrl);
                mItemImageView.setImageBitmap(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Picasso.with(view.getContext()).load(mImageUrl).into(mItemImageView);
        }
        return view;
    }

    public static Bitmap decodeFromBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

}
