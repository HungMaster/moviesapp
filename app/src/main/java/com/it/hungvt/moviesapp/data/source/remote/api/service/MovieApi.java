package com.it.hungvt.moviesapp.data.source.remote.api.service;

import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.ActorResponse;
import com.it.hungvt.moviesapp.data.model.GenreResponse;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.model.MovieResponse;
import com.it.hungvt.moviesapp.data.model.Productor;
import io.reactivex.Observable;
import com.google.gson.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRate(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpcoming(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/now_playing")
    Observable<MovieResponse> getNowPlaying(@Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("movie/popular")
    Observable<MovieResponse> getPopular(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("genre/movie/list")
    Observable<GenreResponse> getGenres(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Observable<Movie> getDetail(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Observable<JsonObject> getVideoTrailer(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("search/movie")
    Observable<MovieResponse> searchMovieByName(@Query("api_key") String apiKey,
            @Query("query") String movieName, @Query("primary_release_year") int year);

    @GET("/3/movie/{id}/credits")
    Observable<ActorResponse> getActorsByIdMovie(@Path("id") int id,
            @Query("api_key") String apiKey);

    @GET("discover/movie")
    Observable<MovieResponse> getMoviesByIdGenre(@Query("with_genres") int id,
            @Query("api_key") String apiKey, @Query("page") int page);

    @GET("discover/movie")
    Observable<MovieResponse> getMoviesByIdActor(@Query("with_people") int id,
            @Query("api_key") String apiKey, @Query("page") int page);

    @GET("discover/movie")
    Observable<MovieResponse> getMoviesByIdProductor(@Query("with_companies") int id,
            @Query("api_key") String apiKey, @Query("page") int page);

    @GET("people/{id}")
    Observable<Actor> getActor(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("company/{id}")
    Observable<Productor> getProductor(@Path("id") int id, @Query("api_key") String apiKey);
}
