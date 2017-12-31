package com.it.hungvt.moviesapp.screen.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.screen.favorite.FavoriteActivity;
import com.it.hungvt.moviesapp.screen.search.SearchActivity;

/**
 * Exposes the data to be used in the Home screen.
 */

public class HomeViewModel extends BaseObservable
        implements HomeContract.ViewModel, NavigationView.OnNavigationItemSelectedListener {

    private HomeContract.Presenter mPresenter;
    private int mGravity;
    private HomePagerAdapter mPagerAdapter;
    private Context mContext;

    public HomeViewModel(Context context, FragmentManager manager) {
        mContext = context;
        mGravity = Gravity.END;
        mPagerAdapter = new HomePagerAdapter(manager);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public int getGravity() {
        return mGravity;
    }

    public void setGravity(int gravity) {
        mGravity = gravity;
        notifyPropertyChanged(BR.gravity);
    }

    @Bindable
    public HomePagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    public void onNavigationClick() {
        mGravity = mGravity != Gravity.START ? Gravity.START : Gravity.END;
        notifyPropertyChanged(BR.gravity);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                mGravity = Gravity.END;
                setGravity(mGravity);
                break;

            case R.id.nav_genres:
                // TODO
                break;

            case R.id.nav_favorite:
                mContext.startActivity(new Intent(mContext, FavoriteActivity.class));
                break;

            case R.id.nav_about_us:
                // TODO

                break;

            case R.id.nav_setting:
                // TODO

                break;
        }
        return true;
    }

    public void onSearch(View view) {
        Intent intent = new Intent(view.getContext(), SearchActivity.class);
        view.getContext().startActivity(intent);
    }
}
