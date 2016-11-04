package com.my.android.demo.jhchen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jhchen on 2016/10/26.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList;
    List<String> mTittleList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tittleList) {
        super(fm);
        mFragmentList =fragments;
        mTittleList = tittleList;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTittleList.get(position);
    }
}
