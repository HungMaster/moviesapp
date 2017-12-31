package com.it.hungvt.moviesapp.data.model;

import android.databinding.BaseObservable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 11/24/2017.
 */

public class BaseModel extends BaseObservable {

    @SerializedName("id")
    @Expose
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
