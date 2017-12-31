package com.it.hungvt.moviesapp.data.source.remote;

import com.it.hungvt.moviesapp.data.source.MovieDataSource;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieApi;

/**
 * Created by Administrator on 11/24/2017.
 */

public abstract class BaseRemoteDataSource implements MovieDataSource{

    MovieApi mMovieApi;

    public BaseRemoteDataSource(MovieApi movieApi){

        mMovieApi = movieApi;
    }
}
