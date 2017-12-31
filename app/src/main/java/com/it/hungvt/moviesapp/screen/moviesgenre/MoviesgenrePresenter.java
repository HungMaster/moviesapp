package com.it.hungvt.moviesapp.screen.moviesgenre;

/**
 * Listens to user actions from the UI ({@link MoviesgenreActivity}), retrieves the data and updates
 * the UI as required.
 */
final class MoviesgenrePresenter implements MoviesgenreContract.Presenter {
    private static final String TAG = MoviesgenrePresenter.class.getName();

    private final MoviesgenreContract.ViewModel mViewModel;

    public MoviesgenrePresenter(MoviesgenreContract.ViewModel viewModel) {
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
