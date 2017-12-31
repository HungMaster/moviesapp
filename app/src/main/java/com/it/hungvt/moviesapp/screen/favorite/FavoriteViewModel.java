package com.it.hungvt.moviesapp.screen.favorite;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.screen.detail.DetailActivity;
import com.it.hungvt.moviesapp.screen.movie.MovieAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Favorite screen.
 */

public class FavoriteViewModel extends BaseObservable implements FavoriteContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> {

    private FavoriteContract.Presenter mPresenter;
    private MovieAdapter mAdapter;
    private Context mContext;
    private List<Movie> mMovies;

    public FavoriteViewModel(Context context) {
        mContext = context;
        mMovies = new ArrayList<>();
        mAdapter = new MovieAdapter(context, mMovies);
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
    public void setPresenter(FavoriteContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMovieFromLocal();
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void loadMovieSuccess(List<Movie> movies) {
        mAdapter.updateMovies(movies);
    }

    @Override
    public void loadMovieFailed(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Bindable
    public MovieAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MovieAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onItemRecyclerViewClick(Movie movie) {
        mContext.startActivity(DetailActivity.getIntent(mContext, movie));
    }

}
