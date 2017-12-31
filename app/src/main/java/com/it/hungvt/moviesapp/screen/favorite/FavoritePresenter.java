package com.it.hungvt.moviesapp.screen.favorite;

import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.FavoriteRepository;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link FavoriteActivity}), retrieves the data and updates
 * the UI as required.
 */
public class FavoritePresenter implements FavoriteContract.Presenter {
    private static final String TAG = FavoritePresenter.class.getName();

    private FavoriteContract.ViewModel mViewModel;
    private FavoriteRepository mFavoriteRepository;

    public FavoritePresenter(FavoriteContract.ViewModel viewModel,
            FavoriteRepository favoriteRepository) {
        mViewModel = viewModel;
        mFavoriteRepository = favoriteRepository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void getMovieFromLocal() {

        List<Movie> movies = mFavoriteRepository.getMovies();
        if (movies.size() > 0) {
            mViewModel.loadMovieSuccess(movies);
        } else {
            mViewModel.loadMovieFailed(String.valueOf(R.string.message_load_move_failure));
        }
    }
}
