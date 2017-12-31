package com.it.hungvt.moviesapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Administrator on 12/9/2017.
 */

public class ActorResponse {

    @SerializedName("cast")
    @Expose
    private List<Actor> mActors;

    public ActorResponse() {
    }

    public ActorResponse(List<Actor> actors) {
        mActors = actors;
    }

    public List<Actor> getActors() {
        return mActors;
    }

    public void setActors(List<Actor> actors) {
        mActors = actors;
    }
}
