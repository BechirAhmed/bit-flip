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

import org.parceler.Parcels;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewImageFragment extends Fragment {
    @Bind(R.id.newItemImageView) ImageView mNewItemImageView;
    private byte[] mImageByte;
    Bitmap mImage;

    public static NewImageFragment newInstance(Bitmap imageBitmap) {
        Bundle args = new Bundle();
        NewImageFragment fragment = new NewImageFragment();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        args.putByteArray("imageByte", byteArray);
        fragment.setArguments(args);
        return fragment;
    }
    public NewImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageByte = getArguments().getByteArray("imageByte");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_image, container, false);
        ButterKnife.bind(this, view);

        mImage = BitmapFactory.decodeByteArray(mImageByte, 0, mImageByte.length);
        mNewItemImageView.setImageBitmap(mImage);

        return view;
    }


}
