package com.it.hungvt.moviesapp.screen.detail;

import android.content.Context;
import com.it.hungvt.moviesapp.BuildConfig;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.model.Productor;
import com.it.hungvt.moviesapp.data.source.FavoriteRepository;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.data.source.local.FavoriteLocalDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class DetailPresenter implements DetailContract.Presenter {
    private static final String TAG = DetailPresenter.class.getName();

    private DetailContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;
    private FavoriteRepository mFavoriteRepository;
    private Context mContext;

    public DetailPresenter(Context context, DetailContract.ViewModel viewModel,
            MovieRepository movieRepository, FavoriteRepository favoriteRepository) {
        mContext = context;
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
        mFavoriteRepository = favoriteRepository;
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
    public void getMovie(int id) {

        mCompositeDisposable.add(mMovieRepository.getDetail(id, BuildConfig.API_KEY_MOVIE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<Movie>() {
                    @Override
                    public void onNext(Movie movie) {
                        mViewModel.getMovieSuccess(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.getMovieFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getVideoTrailer(int id) {

        mCompositeDisposable.add(mMovieRepository.getVideoTrailer(id, BuildConfig.API_KEY_MOVIE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {

                        mViewModel.getTrailerSuccess(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                        mViewModel.getTrailerFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void addMovieToLocal(Movie movie) {
        if (!mFavoriteRepository.checkMovieExists(movie)) {
            mFavoriteRepository.insertMovie(movie);
            mViewModel.addMovieFavoriteSuccess(
                    mContext.getString(R.string.message_add_move_success));
        } else {
            mViewModel.addMovieFavoriteSuccess(
                    mContext.getString(R.string.message_add_move_failure));
        }
    }

    @Override
    public void deleteMovieFromLocal(Movie movie) {
        if (mFavoriteRepository.checkMovieExists(movie)) {
            mFavoriteRepository.deleteMovie(movie);
            mViewModel.deleteMovieFavoriteSuccess(
                    mContext.getString(R.string.message_delete_move_success));
        } else {
            mViewModel.deleteMovieFavoriteSuccess(
                    mContext.getString(R.string.message_delete_move_failure));
        }
    }

    @Override
    public void getActorsByIdMovie(int id) {
        mCompositeDisposable.add(mMovieRepository.getActorsByIdMovie(id, BuildConfig.API_KEY_MOVIE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Actor>>() {
                    @Override
                    public void onNext(List<Actor> actors) {
                        mViewModel.getActorByIdMovieSuccess(actors);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.getActorByIdMovieFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }



}
