package com.it.hungvt.moviesapp.data.source;

import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.model.Productor;
import com.it.hungvt.moviesapp.data.source.remote.MovieRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

public class MovieRepository implements MovieDataSource {

    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource remoteDataSource) {
        mMovieRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey, int page) {
        return mMovieRemoteDataSource.getPopular(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey, int page) {
        return mMovieRemoteDataSource.getNowPlaying(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey, int page) {
        return mMovieRemoteDataSource.getUpcoming(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey, int page) {
        return mMovieRemoteDataSource.getTopRate(apiKey, page);
    }

    @Override
    public Observable<Movie> getDetail(int id, String apiKey) {
        return mMovieRemoteDataSource.getDetail(id, apiKey);
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mMovieRemoteDataSource.getGenres(apiKey);
    }

    @Override
    public Observable<String> getVideoTrailer(int id, String apiKey) {
        return mMovieRemoteDataSource.getVideoTrailer(id, apiKey);
    }

    @Override
    public Observable<List<Movie>> searchMovieByName(String apiKey, String name, int year) {
        return mMovieRemoteDataSource.searchMovieByName(apiKey, name, year);
    }

    @Override
    public Observable<List<Actor>> getActorsByIdMovie(int id, String apiKey) {
        return mMovieRemoteDataSource.getActorsByIdMovie(id, apiKey);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdGenre(int id, String apiKey, int page) {
        return mMovieRemoteDataSource.getMoviesByIdGenre(id, apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdActor(int id, String apiKey, int page) {
        return mMovieRemoteDataSource.getMoviesByIdActor(id, apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdProductor(int id, String apiKey, int page) {
        return mMovieRemoteDataSource.getMoviesByIdProductor(id, apiKey, page);
    }

    @Override
    public Observable<Actor> getActor(int id, String apiKey) {
        return mMovieRemoteDataSource.getActor(id, apiKey);
    }

    @Override
    public Observable<Productor> getProductor(int id, String apiKey) {
        return mMovieRemoteDataSource.getProductor(id, apiKey);
    }
}
