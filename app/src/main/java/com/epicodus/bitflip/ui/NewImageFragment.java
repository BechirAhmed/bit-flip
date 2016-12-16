package com.epicodus.bitflip.ui;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
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
public class NewImageFragment extends Fragment {
    @Bind(R.id.newItemImageView) ImageView mNewItemImageView;
    private String mImageByte;

    public static NewImageFragment newInstance(String imageByte) {
        Bundle args = new Bundle();
        NewImageFragment fragment = new NewImageFragment();
        args.putString("imageByte", imageByte);
        fragment.setArguments(args);
        return fragment;
    }
    public NewImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageByte = getArguments().getString("imageByte");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_image, container, false);
        ButterKnife.bind(this, view);

        try {
            Bitmap image = decodeFromBase64(mImageByte);
            mNewItemImageView.setImageBitmap(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    public static Bitmap decodeFromBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

}
