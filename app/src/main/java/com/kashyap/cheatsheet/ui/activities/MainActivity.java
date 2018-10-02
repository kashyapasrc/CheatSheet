package com.kashyap.cheatsheet.ui.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;

import com.kashyap.cheatsheet.R;
import com.kashyap.cheatsheet.library.ExpandingViewPager;
import com.kashyap.cheatsheet.ui.view_pager_adapter.CheatSheetViewPagerAdapter;
import com.kashyap.cheatsheet.domain.models.Travel;
import com.kashyap.cheatsheet.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    ExpandingViewPager expandingViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupWindowAnimations();

        CheatSheetViewPagerAdapter adapter = new CheatSheetViewPagerAdapter(getSupportFragmentManager());
        adapter.addAll(generateTravelList());
        viewPager.setAdapter(adapter);

        expandingViewPager = new ExpandingViewPager(viewPager);
        expandingViewPager.setupViewPager();
    }

    @Override
    public void onBackPressed() {
        if (!expandingViewPager.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Explode slideTransition = new Explode();
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    private List<Travel> generateTravelList() {
        List<Travel> travels = new ArrayList<>();
        for (int i = 0; i < Constant.CHEAT_SHEET_COUNT; ++i) {
            travels.add(new Travel("Python", R.drawable.python_1200));
            //travels.add(new Travel("New York", R.drawable.newyork));
        }
        return travels;
    }
}
