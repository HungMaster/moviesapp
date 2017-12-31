package com.it.hungvt.moviesapp.screen.movie;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.screen.detail.DetailActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Movie screen.
 */

public class MovieViewModel extends BaseObservable implements MovieContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> {

    private MovieContract.Presenter mPresenter;
    private Context mContext;
    private MovieAdapter mAdapter;
    private List<Movie> mMovies;
    private int mCategoryId;
    private int mPageNumber;
    private boolean mIsLoadingMore;
    private int mGenreId;

    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (dy <= 0) {
                return;
            }
            LinearLayoutManager layoutManager =
                    (LinearLayoutManager) recyclerView.getLayoutManager();

            int childCount = layoutManager.getChildCount();
            int itemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            //            int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            if (!mIsLoadingMore && (childCount + firstVisibleItemPosition >= itemCount)) {
                setLoadingMore(true);
                loadingMore();
            }
        }
    };

    public MovieViewModel(Context context, int categoryId, int genreId) {
        mContext = context;
        mCategoryId = categoryId;
        mGenreId = genreId;
        mMovies = new ArrayList<>();
        mPageNumber = 1;
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
    public void setPresenter(MovieContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.loadMovieFromApi(mCategoryId, mPageNumber,mGenreId);
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void loadMovieSuccess(List<Movie> movies) {
        mAdapter.updateMovies(movies);
        setLoadingMore(false);
    }

    @Override
    public void loadMovieFailed(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemRecyclerViewClick(Movie movie) {

        mContext.startActivity(DetailActivity.getIntent(mContext, movie));
    }

    private void loadingMore() {
        mPageNumber++;
        mPresenter.loadMovieFromApi(mCategoryId, mPageNumber,mGenreId);
    }

    @Bindable
    public MovieAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MovieAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public boolean isLoadingMore() {
        return mIsLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        mIsLoadingMore = loadingMore;
        notifyPropertyChanged(BR.loadingMore);
    }

    @Bindable
    public RecyclerView.OnScrollListener getScrollListener() {
        return mScrollListener;
    }
}
