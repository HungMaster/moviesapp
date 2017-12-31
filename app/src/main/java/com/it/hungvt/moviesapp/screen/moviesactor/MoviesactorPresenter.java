package com.it.hungvt.moviesapp.screen.moviesactor;

/**
 * Listens to user actions from the UI ({@link MoviesactorActivity}), retrieves the data and updates
 * the UI as required.
 */
final class MoviesactorPresenter implements MoviesactorContract.Presenter {
    private static final String TAG = MoviesactorPresenter.class.getName();

    private final MoviesactorContract.ViewModel mViewModel;

    public MoviesactorPresenter(MoviesactorContract.ViewModel viewModel) {
        mViewModel = viewModel;
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
}
