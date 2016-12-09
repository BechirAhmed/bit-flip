package com.epicodus.bitflip.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.bitflip.R;
import com.epicodus.bitflip.model.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by DroAlvarez on 12/8/16.
 */

public class FirebaseItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseItemViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindItem(Item item) {
        ImageView itemImageView = (ImageView) mView.findViewById(R.id.itemImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.itemNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView priceTextView = (TextView) mView.findViewById(R.id.priceTextView);

        Picasso.with(mContext)
                .load(item.getImageUrls().get(0))
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(itemImageView);

        nameTextView.setText(item.getName());
        categoryTextView.setText(item.getCategory());
        priceTextView.setText(item.getPrice());
    }
}
