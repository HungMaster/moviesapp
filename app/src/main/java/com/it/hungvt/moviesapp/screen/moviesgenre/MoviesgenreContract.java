package com.it.hungvt.moviesapp.screen.moviesgenre;

import com.it.hungvt.moviesapp.screen.BasePresenter;
import com.it.hungvt.moviesapp.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MoviesgenreContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
