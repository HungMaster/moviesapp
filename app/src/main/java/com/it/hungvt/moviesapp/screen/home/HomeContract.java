package com.it.hungvt.moviesapp.screen.home;

import com.it.hungvt.moviesapp.screen.BasePresenter;
import com.it.hungvt.moviesapp.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {
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
