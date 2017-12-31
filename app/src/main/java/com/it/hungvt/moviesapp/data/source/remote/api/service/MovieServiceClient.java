package com.it.hungvt.moviesapp.data.source.remote.api.service;

import com.it.hungvt.moviesapp.utils.Constant;

/**
 * Created by Administrator on 11/24/2017.
 */

public class MovieServiceClient extends ServiceClient {

    private static MovieApi sMovieApi;

    public static MovieApi getInstance(){

        if (sMovieApi == null){

            sMovieApi = createService(Constant.END_POINT_URL,MovieApi.class);
        }
        return sMovieApi;
    }
}
