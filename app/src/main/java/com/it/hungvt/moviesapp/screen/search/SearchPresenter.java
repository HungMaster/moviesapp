package com.it.hungvt.moviesapp.screen.search;

import android.content.Context;
import com.it.hungvt.moviesapp.BuildConfig;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link SearchActivity}), retrieves the data and updates
 * the UI as required.
 */
public class SearchPresenter implements SearchContract.Presenter {
    private static final String TAG = SearchPresenter.class.getName();

    private final SearchContract.ViewModel mViewModel;
    private CompositeDisposable mCompositeDisposable;
    private MovieRepository mMovieRepository;

    public SearchPresenter(SearchContract.ViewModel viewModel, MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void searchMovieByName(String name) {

        mCompositeDisposable.add(mMovieRepository.searchMovieByName(BuildConfig.API_KEY_MOVIE, name,
                Calendar.getInstance().get(Calendar.YEAR))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {

                    @Override
                    public void onNext(List<Movie> movies) {
                        mViewModel.onSearchSuccess(movies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onSearchFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
