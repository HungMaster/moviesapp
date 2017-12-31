package com.it.hungvt.moviesapp.screen.movie;

import com.it.hungvt.moviesapp.BuildConfig;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.utils.TabTypeName;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_ACTOR_ID;
import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_GENRE_ID;
import static com.it.hungvt.moviesapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.moviesapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.moviesapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.moviesapp.utils.TabTypeName.UP_COMING;

public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;

    public MoviePresenter(MovieContract.ViewModel viewModel, MovieRepository movieRepository) {
        mViewModel = viewModel;
        mCompositeDisposable = new CompositeDisposable();
        mMovieRepository = movieRepository;
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
    public void loadMovieFromApi(@TabTypeName int categoryId, int page, int id) {

        Observable<List<Movie>> observable = null;
        switch (categoryId) {

            case TOP_RATE:
                observable = mMovieRepository.getTopRate(BuildConfig.API_KEY_MOVIE, page);
                break;

            case UP_COMING:
                observable = mMovieRepository.getUpcoming(BuildConfig.API_KEY_MOVIE, page);
                break;

            case NOW_PLAYING:
                observable = mMovieRepository.getNowPlaying(BuildConfig.API_KEY_MOVIE, page);
                break;

            case POPULAR:
                observable = mMovieRepository.getPopular(BuildConfig.API_KEY_MOVIE, page);
                break;

            case MOVIES_OF_GENRE_ID:
                observable =
                        mMovieRepository.getMoviesByIdGenre(id, BuildConfig.API_KEY_MOVIE, page);
            case MOVIES_OF_ACTOR_ID:
                observable =
                        mMovieRepository.getMoviesByIdActor(id, BuildConfig.API_KEY_MOVIE, page);
        }

        mCompositeDisposable.add(observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> movies) {
                        mViewModel.loadMovieSuccess(movies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.loadMovieFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
