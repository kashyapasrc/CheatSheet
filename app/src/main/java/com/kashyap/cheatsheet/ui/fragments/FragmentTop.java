package com.kashyap.cheatsheet.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kashyap.cheatsheet.R;
import com.kashyap.cheatsheet.ui.BaseFragment;
import com.kashyap.cheatsheet.ui.activities.InfoActivity;
import com.kashyap.cheatsheet.library.fragments.ExpandingFragment;
import com.kashyap.cheatsheet.domain.models.Travel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTop extends BaseFragment implements ExpandingFragment.ChildTop {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.title)
    TextView title;
    @Nullable
    ExpandingFragment expandingFragment;

    public static FragmentTop newInstance(Travel travel) {
        Bundle args = new Bundle();
        FragmentTop fragmentTop = new FragmentTop();
        args.putParcelable(ARG_TRAVEL, travel);
        fragmentTop.setArguments(args);
        return fragmentTop;
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_front;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            travel = args.getParcelable(ARG_TRAVEL);
        }

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if (travel != null) {
            image.setImageResource(travel.getImage());
            title.setText(travel.getName());
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandingFragment != null) {
                    if (expandingFragment.isOpenend()) {
                        startInfoActivity(view, travel);
                    } else {
                        expandingFragment.open();
                    }
                }
            }
        });
    }

    @Override
    public void onAttachedToExpanding(ExpandingFragment expandingFragment) {
        this.expandingFragment = expandingFragment;
    }

    @Override
    public void onDetachedToExpanding() {
        this.expandingFragment = null;
    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, Travel travel) {
        FragmentActivity activity = getActivity();
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance(activity, travel),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }
}
