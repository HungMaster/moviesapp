package com.it.hungvt.moviesapp.screen.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.it.hungvt.moviesapp.MainApplication;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.screen.movie.MovieFragment;
import com.it.hungvt.moviesapp.utils.Constant;
import com.it.hungvt.moviesapp.utils.TabTypeName;
import java.util.ArrayList;
import java.util.List;

import static com.it.hungvt.moviesapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.moviesapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.moviesapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.moviesapp.utils.TabTypeName.UP_COMING;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(@TabTypeName int position) {

        switch (position) {

            case TOP_RATE:
                return MovieFragment.getInstance(TOP_RATE);

            case UP_COMING:
                return MovieFragment.getInstance(UP_COMING);

            case NOW_PLAYING:
                return MovieFragment.getInstance(NOW_PLAYING);

            case POPULAR:
                return MovieFragment.getInstance(POPULAR);

            default:
                return MovieFragment.getInstance(POPULAR);
        }
    }

    @Override
    public int getCount() {

        return Constant.FRAGMENT_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case TOP_RATE:
                return MainApplication.getsInstance().getString(R.string.title_tab_top_rate);

            case UP_COMING:
                return MainApplication.getsInstance().getString(R.string.title_tab_up_coming);

            case NOW_PLAYING:
                return MainApplication.getsInstance().getString(R.string.title_tab_now_playing);

            case POPULAR:
                return MainApplication.getsInstance().getString(R.string.title_tab_popular);

            default:
                return MainApplication.getsInstance().getString(R.string.title_tab_popular);
        }
    }
}
