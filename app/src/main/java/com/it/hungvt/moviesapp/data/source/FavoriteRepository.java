package com.it.hungvt.moviesapp.data.source;

import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.local.FavoriteLocalDataSource;
import java.util.List;

public class FavoriteRepository implements FavoriteDataSource {

    private FavoriteLocalDataSource mFavoriteLocalDataSource;

    public FavoriteRepository(FavoriteLocalDataSource favoriteLocalDataSource) {

        mFavoriteLocalDataSource = favoriteLocalDataSource;
    }

    @Override
    public List<Movie> getMovies() {
        return mFavoriteLocalDataSource.getMovies();
    }

    @Override
    public boolean insertMovie(Movie movie) {
        return mFavoriteLocalDataSource.insertMovie(movie);
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        return mFavoriteLocalDataSource.deleteMovie(movie);
    }

    @Override
    public boolean checkMovieExists(Movie movie) {
        return mFavoriteLocalDataSource.checkMovieExists(movie);
    }
}
