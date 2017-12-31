package com.it.hungvt.moviesapp.data.source.remote;

import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.ActorResponse;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.data.model.GenreResponse;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.model.MovieResponse;
import com.it.hungvt.moviesapp.data.model.Productor;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MovieRemoteDataSource extends BaseRemoteDataSource {

    public MovieRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey, int page) {
        return mMovieApi.getPopular(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey, int page) {
        return mMovieApi.getNowPlaying(apiKey, page)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey, int page) {
        return mMovieApi.getUpcoming(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey, int page) {
        return mMovieApi.getTopRate(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<Movie> getDetail(int id, String apiKey) {
        return mMovieApi.getDetail(id, apiKey);
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mMovieApi.getGenres(apiKey).map(new Function<GenreResponse, List<Genre>>() {
            @Override
            public List<Genre> apply(GenreResponse genreResponse) throws Exception {
                return genreResponse.getGenres();
            }
        });
    }

    @Override
    public Observable<String> getVideoTrailer(int id, String apiKey) {
        return mMovieApi.getVideoTrailer(id, apiKey).map(new Function<JsonObject, String>() {
            @Override
            public String apply(JsonObject jsonObject) throws Exception {

                JsonArray videos = jsonObject.getAsJsonArray("results");
                JsonObject video = videos.get(0).getAsJsonObject();
                return video.get("key").getAsString();
            }
        });
    }

    @Override
    public Observable<List<Movie>> searchMovieByName(String apiKey, String name, int year) {
        return mMovieApi.searchMovieByName(apiKey, name, year)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<List<Actor>> getActorsByIdMovie(int id, String apiKey) {
        return mMovieApi.getActorsByIdMovie(id, apiKey)
                .map(new Function<ActorResponse, List<Actor>>() {

                    @Override
                    public List<Actor> apply(ActorResponse actorResponse) throws Exception {
                        return actorResponse.getActors();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdGenre(int id, String apiKey, int page) {
        return mMovieApi.getMoviesByIdGenre(id, apiKey, page)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdActor(int id, String apiKey, int page) {
        return mMovieApi.getMoviesByIdActor(id, apiKey, page)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdProductor(int id, String apiKey, int page) {
        return mMovieApi.getMoviesByIdProductor(id, apiKey, page)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<Actor> getActor(int id, String apiKey) {
        return mMovieApi.getActor(id,apiKey);
    }

    @Override
    public Observable<Productor> getProductor(int id, String apiKey) {
        return mMovieApi.getProductor(id,apiKey);
    }
}
