package com.it.hungvt.moviesapp.data.source;

import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.model.Productor;
import io.reactivex.Observable;
import java.util.List;

public interface MovieDataSource {

    Observable<List<Movie>> getPopular(String apiKey, int page);

    Observable<List<Movie>> getNowPlaying(String apiKey, int page);

    Observable<List<Movie>> getUpcoming(String apiKey, int page);

    Observable<List<Movie>> getTopRate(String apiKey, int page);

    Observable<Movie> getDetail(int id, String apiKey);

    Observable<List<Genre>> getGenres(String apiKey);

    Observable<String> getVideoTrailer(int id, String apiKey);

    Observable<List<Movie>> searchMovieByName(String apiKey, String name, int year);

    Observable<List<Actor>> getActorsByIdMovie(int id, String apiKey);

    Observable<List<Movie>> getMoviesByIdGenre(int id, String apiKey, int page);

    Observable<List<Movie>> getMoviesByIdActor(int id, String apiKey, int page);

    Observable<List<Movie>> getMoviesByIdProductor(int id, String apiKey, int page);

    Observable<Actor> getActor(int id, String apiKey);

    Observable<Productor> getProductor(int id, String apiKey);
}
