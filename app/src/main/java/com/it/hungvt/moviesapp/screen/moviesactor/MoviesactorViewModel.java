package com.it.hungvt.moviesapp.screen.moviesactor;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.screen.movie.MovieFragment;

import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_ACTOR_ID;

/**
 * Exposes the data to be used in the Moviesactor screen.
 */

public class MoviesactorViewModel extends BaseObservable implements MoviesactorContract.ViewModel {

    private MoviesactorContract.Presenter mPresenter;
    private FragmentManager mManager;
    private Fragment mFragment;
    private Context mContext;

    public MoviesactorViewModel(Context context, FragmentManager manager, Actor actor) {
        mContext = context;
        mManager = manager;
        mFragment = MovieFragment.getInstance(MOVIES_OF_ACTOR_ID, actor.getId());
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
    public void setPresenter(MoviesactorContract.Presenter presenter) {
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
