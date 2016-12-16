package com.epicodus.bitflip.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.bitflip.ui.ItemDetailFragment;
import com.epicodus.bitflip.ui.NewImageFragment;

import java.util.List;

/**
 * Created by DroAlvarez on 12/16/16.
 */

public class NewImagePagerAdapter extends FragmentPagerAdapter{
    private List<String> mImages;

    public NewImagePagerAdapter(FragmentManager fm, List<String> images) {
        super(fm);
        mImages = images;
    }

    @Override
    public Fragment getItem(int position) {
        return NewImageFragment.newInstance(mImages.get(position));
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mImages.get(position);
    }
}

