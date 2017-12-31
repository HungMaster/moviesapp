package com.it.hungvt.moviesapp.data.model;

import android.databinding.Bindable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.it.hungvt.moviesapp.BR;

/**
 * Created by Administrator on 12/9/2017.
 */

public class Productor extends BaseModel{

    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("logo_path")
    @Expose
    private String mLogoUrl;

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLogoUrl() {
        return mLogoUrl;
    }

    public void setLogoURL(String logoUrl) {
        mLogoUrl = logoUrl;
        notifyPropertyChanged(BR.logoUrl);
    }
}
