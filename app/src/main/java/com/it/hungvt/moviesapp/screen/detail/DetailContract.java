package com.it.hungvt.moviesapp.screen.detail;

import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.screen.BasePresenter;
import com.it.hungvt.moviesapp.screen.BaseViewModel;
import com.it.hungvt.moviesapp.data.model.Movie;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {

        void getMovieSuccess(Movie movie);

        void getMovieFailure(String message);

        void getTrailerSuccess(String urlVideo);

        void getTrailerFailure(String message);

        void getActorByIdMovieSuccess(List<Actor> actors);

        void getActorByIdMovieFailure(String message);

        void addMovieFavoriteSuccess(String message);

        void deleteMovieFavoriteSuccess(String message);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {

        void getMovie(int id);

        void getVideoTrailer(int id);

        void getActorsByIdMovie(int id);

        void addMovieToLocal(Movie movie);

        void deleteMovieFromLocal(Movie movie);
    }
}
