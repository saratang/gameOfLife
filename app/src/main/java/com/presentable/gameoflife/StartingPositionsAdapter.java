package com.presentable.gameoflife;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class StartingPositionsAdapter extends FragmentPagerAdapter {
    public StartingPositionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return StartingPositionFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 1;
    }

}
