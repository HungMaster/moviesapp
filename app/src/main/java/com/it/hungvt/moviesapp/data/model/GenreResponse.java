package com.it.hungvt.moviesapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GenreResponse {
    @SerializedName("genres")
    @Expose
    List<Genre> mGenres;

    public GenreResponse() {
    }

    public GenreResponse(List<Genre> genres) {
        mGenres = genres;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }
}
