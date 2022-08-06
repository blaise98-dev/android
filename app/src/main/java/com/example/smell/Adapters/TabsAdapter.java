package com.example.smell.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.smell.Fragments.SmellLocalListFragment;
import com.example.smell.Fragments.SmellRemoteListFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoOfTabs){
        super(fm);
        this.mNumOfTabs = NoOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new SmellRemoteListFragment();
        }
        return new SmellLocalListFragment();
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}