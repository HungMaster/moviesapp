package com.it.hungvt.moviesapp.screen.home;

import com.it.hungvt.moviesapp.data.source.MovieRepository;

/**
 * Listens to user actions from the UI ({@link HomeActivity}), retrieves the data and updates
 * the UI as required.
 */
public class HomePresenter implements HomeContract.Presenter {

    private  HomeContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;

    public HomePresenter(HomeContract.ViewModel viewModel, MovieRepository movieRepository) {

        mViewModel = viewModel;
        movieRepository = movieRepository;
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
