package com.it.hungvt.moviesapp.screen.moviesgenre;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.screen.movie.MovieFragment;

import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_GENRE_ID;

/**
 * Exposes the data to be used in the Moviesgenre screen.
 */

public class MoviesgenreViewModel extends BaseObservable implements MoviesgenreContract.ViewModel {

    private MoviesgenreContract.Presenter mPresenter;
    private FragmentManager mManager;
    private Context mContext;
    private Fragment mFragment;

    public MoviesgenreViewModel(Context context, FragmentManager manager, Genre genre) {
        mContext = context;
        mManager = manager;
        mFragment = MovieFragment.getInstance(MOVIES_OF_GENRE_ID, genre.getId());
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
    public void setPresenter(MoviesgenreContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public FragmentManager getManager() {
        return mManager;
    }

    public void setManager(FragmentManager manager) {
        mManager = manager;
        notifyPropertyChanged(BR.manager);
    }

    @Bindable
    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
        notifyPropertyChanged(BR.fragment);
    }
}
