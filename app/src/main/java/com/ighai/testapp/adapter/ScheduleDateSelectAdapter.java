package com.ighai.testapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ighai.testapp.activity.SendDataForFragment;
import com.ighai.testapp.fragment.ScheduleLimitFragment;
import com.ighai.testapp.fragment.ScheduleLocationFragment;
import com.ighai.testapp.fragment.ScheduleTimeFragment;


public class ScheduleDateSelectAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"시간", "지역", "제한대수"};
    private ScheduleTimeFragment fragment1;
    private ScheduleLocationFragment fragment2;
    private ScheduleLimitFragment fragment3;

    public ScheduleDateSelectAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = ScheduleTimeFragment.newInstance();
        fragment2 = ScheduleLocationFragment.newInstance();
        fragment3 = ScheduleLimitFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragment1;
            case 1:
                return fragment2;
            case 2:
                return fragment3;
            default:
                return null;
        }
    }

}