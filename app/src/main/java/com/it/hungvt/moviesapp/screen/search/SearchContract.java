package com.it.hungvt.moviesapp.screen.search;

import com.it.hungvt.moviesapp.screen.BasePresenter;
import com.it.hungvt.moviesapp.screen.BaseViewModel;
import com.it.hungvt.moviesapp.data.model.Movie;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface SearchContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onSearchSuccess(List<Movie> movies);

        void onSearchFail(String message);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void searchMovieByName(String name);
    }
}
