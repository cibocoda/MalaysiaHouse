package com.fiveteam.malaysiahouse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zop on 2016/12/17.
 */

public class P1slcVPAdapter extends FragmentPagerAdapter {

    public P1slcVPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return P1slcvpItemsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
