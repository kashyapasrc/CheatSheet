package com.kashyap.cheatsheet.utils;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class ActivityUtils {

    public static void attachFragmentToActivity(FragmentManager fragmentManager, @IdRes int layoutId, Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(layoutId, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

    public static void removeAllFragmentFromView(FragmentManager fragmentManager) {
        for (Fragment fragment : fragmentManager.getFragments()) {
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
    }
}
