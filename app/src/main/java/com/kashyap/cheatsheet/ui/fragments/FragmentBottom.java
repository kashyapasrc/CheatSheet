package com.kashyap.cheatsheet.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashyap.cheatsheet.R;
import com.kashyap.cheatsheet.library.fragments.ExpandingFragment;
import com.kashyap.cheatsheet.ui.BaseFragment;

import java.io.Serializable;

public class FragmentBottom extends BaseFragment implements Serializable, ExpandingFragment.ChildBottom {

    ExpandingFragment expandingFragment;

    public static FragmentBottom newInstance() {
        return new FragmentBottom();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_bottom;
    }



    @Override
    public void onAttachedToExpanding(ExpandingFragment expandingFragment) {
        this.expandingFragment = expandingFragment;
    }

    @Override
    public void onDetachedToExpanding() {
        this.expandingFragment = null;
    }
}
