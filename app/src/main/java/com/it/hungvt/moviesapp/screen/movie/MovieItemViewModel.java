package com.it.hungvt.moviesapp.screen.movie;

import android.databinding.BaseObservable;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import com.it.hungvt.moviesapp.data.model.Movie;

/**
 * Created by Administrator on 11/20/2017.
 */

public class MovieItemViewModel extends BaseObservable {

    private Movie mMovie;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> mItemClickListener;

    public MovieItemViewModel(Movie movie,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> itemClickListener) {
        mMovie = movie;
        mItemClickListener = itemClickListener;
    }

    public void onItemClicked() {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mMovie);
    }


}
