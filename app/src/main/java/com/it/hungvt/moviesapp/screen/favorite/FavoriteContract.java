package com.it.hungvt.moviesapp.screen.favorite;

import com.it.hungvt.moviesapp.screen.BasePresenter;
import com.it.hungvt.moviesapp.screen.BaseViewModel;
import com.it.hungvt.moviesapp.data.model.Movie;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface FavoriteContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void loadMovieSuccess(List<Movie> movies);
        void loadMovieFailed(String message);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMovieFromLocal();
    }
}
