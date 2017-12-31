package com.it.hungvt.moviesapp.data.source;

import com.it.hungvt.moviesapp.data.model.Movie;
import java.util.List;

/**
 * Created by Administrator on 11/26/2017.
 */

public interface FavoriteDataSource {

    List<Movie> getMovies();

    boolean insertMovie(Movie movie);

    boolean deleteMovie(Movie movie);

    boolean checkMovieExists(Movie movie);
}
