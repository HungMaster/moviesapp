package com.it.hungvt.moviesapp.screen.search;

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
 * Exposes the data to be used in the Search screen.
 */

public class SearchViewModel extends BaseObservable implements SearchContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> {

    private SearchContract.Presenter mPresenter;
    private Context mContext;
    private MovieAdapter mAdapter;
    private List<Movie> mMovies;

    public SearchViewModel(Context context) {
        mContext = context;
        mMovies = new ArrayList<>();
        mAdapter = new MovieAdapter(mContext, mMovies);
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onSearchSuccess(List<Movie> movies) {
        mAdapter.updateMovies(movies);
    }

    @Override
    public void onSearchFail(String message) {
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

    public boolean onQueryTextSubmit(String s) {
        if (s.equals("")) return false;
        mPresenter.searchMovieByName(s);
        return true;
    }

    @Override
    public void onItemRecyclerViewClick(Movie movie) {
        mContext.startActivity(DetailActivity.getIntent(mContext, movie));
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }
}
