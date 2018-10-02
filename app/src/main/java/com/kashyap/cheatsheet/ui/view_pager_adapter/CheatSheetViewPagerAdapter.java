package com.kashyap.cheatsheet.ui.view_pager_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.kashyap.cheatsheet.ui.fragments.TravelExpandingFragment;
import com.kashyap.cheatsheet.library.ExpandingViewPagerAdapter;
import com.kashyap.cheatsheet.domain.models.Travel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qs on 16/5/30.
 */
public class CheatSheetViewPagerAdapter extends ExpandingViewPagerAdapter {

    private List<Travel> travels;

    public CheatSheetViewPagerAdapter(FragmentManager fm) {
        super(fm);
        travels = new ArrayList<>();
    }

    public void addAll(List<Travel> travels) {
        this.travels.addAll(travels);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Travel travel = travels.get(position);
        return TravelExpandingFragment.newInstance(travel);
    }

    @Override
    public int getCount() {
        return travels.size();
    }

}
