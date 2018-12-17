package com.example.kccistc.seoul;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
//        Fragment fragment = null;
//        if(i == 0) {
//            fragment = new Historty_fragment1();
//        } else if(i == 1) {
//            fragment = new Historty_fragment2();
//
//        } else if(i == 2) {
//            fragment = new Historty_fragment3();
//
//        } else if(i == 3) {
//            fragment = new Historty_fragment4();
//
//        }
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}
