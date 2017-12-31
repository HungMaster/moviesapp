package com.it.hungvt.moviesapp.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.it.hungvt.moviesapp.BuildConfig;
import com.it.hungvt.moviesapp.screen.favorite.FavoriteActivity;
import com.it.hungvt.moviesapp.screen.home.HomeActivity;
import com.it.hungvt.moviesapp.screen.search.SearchActivity;
import com.it.hungvt.moviesapp.utils.Constant;
import com.it.hungvt.moviesapp.utils.LayoutManagerUtils;

public class BindingUtils {

    @BindingAdapter("recyclerAdapter")
    public static void setAdapterForRecyclerView(RecyclerView view, RecyclerView.Adapter adapter) {

        view.setAdapter(adapter);
    }

    @BindingAdapter("supportActionBarFavorite")
    public static void setSupportActionBarFavorite(Toolbar toolbar, FavoriteActivity activity) {
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
    }

    @BindingAdapter("supportActionBarSearch")
    public static void setSupportActionBarSearch(Toolbar toolbar, SearchActivity activity) {
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
    }

    @BindingAdapter("drawerState")
    public static void drawerState(DrawerLayout drawerLayout, int gravity) {

        if (gravity == Gravity.START) {
            drawerLayout.openDrawer(gravity);
        } else {
            drawerLayout.closeDrawers();
        }
    }

    @BindingAdapter({ "pagerAdapter" })
    public static void setPageAdapter(ViewPager pager, FragmentPagerAdapter adapter) {
        pager.setAdapter(adapter);
    }

    @BindingAdapter({ "viewPager" })
    public static void setViewPagerTabs(TabLayout view, ViewPager pagerView) {
        view.setupWithViewPager(pagerView);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManagerUtils.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager.layout(recyclerView));
    }

    @BindingAdapter({ "navigationListener" })
    public static void setNavigationListener(NavigationView navigationView,
            NavigationView.OnNavigationItemSelectedListener listener) {
        navigationView.setNavigationItemSelectedListener(listener);
    }

    @BindingAdapter({ "setImage" })
    public static void setImageView(ImageView imageView, String url) {
        String imageUrl = Constant.BASE_POSTER_PATH + url;
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("keyVideoTrailer")
    public static void setKeyTrailer(YouTubePlayerView youTubePlayerView, String keyVideoTrailer) {

        if (keyVideoTrailer == null) {
            return;
        }

        youTubePlayerView.initialize(BuildConfig.API_KEY_YOUTUBE,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b) {
                        if (!b) {
                            youTubePlayer.cueVideo(keyVideoTrailer);
                        }
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                            YouTubeInitializationResult youTubeInitializationResult) {

                        Toast.makeText(youTubePlayerView.getContext(),
                                youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @BindingAdapter("scrollListener")
    public static void setScrollListener(RecyclerView recyclerView,
            RecyclerView.OnScrollListener scrollListener) {

        recyclerView.addOnScrollListener(scrollListener);
        recyclerView.setHasFixedSize(true);
    }

    @BindingAdapter({ "manager", "fragment" })
    public static void setFragmentManager(FrameLayout frameLayout, FragmentManager manager,
            Fragment fragment) {
        manager.beginTransaction().replace(frameLayout.getId(), fragment).commit();
    }
}
