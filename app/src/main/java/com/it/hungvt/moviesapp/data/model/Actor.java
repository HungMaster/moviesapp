package com.it.hungvt.moviesapp.data.model;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.it.hungvt.moviesapp.BR;
import java.util.Date;

/**
 * Created by Administrator on 12/9/2017.
 */

public class Actor extends BaseModel implements Parcelable {
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("profile_path")
    @Expose
    private String mAvatarUrl;
    @SerializedName("birthday")
    @Expose
    private Date mBirthday;
    @SerializedName("biography")
    @Expose
    private String mBiography;
    @SerializedName("place_of_birth")
    @Expose
    private String mPlaceOfBirth;

    protected Actor(Parcel in) {
        setId(in.readInt());
        mName = in.readString();
        mAvatarUrl = in.readString();
//        mBirthday = new Date(in.readLong());
        mBiography = in.readString();
        mPlaceOfBirth = in.readString();
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>() {
        @Override
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(mName);
        dest.writeString(mBiography);
        dest.writeString(mPlaceOfBirth);
//        dest.writeLong(mBirthday.getTime());
    }
    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
        notifyPropertyChanged(BR.avatarUrl);
    }

    public Date getBirthday() {
        return mBirthday;
    }

    public void setBirthday(Date birthday) {
        mBirthday = birthday;
    }

    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        mPlaceOfBirth = placeOfBirth;
    }
}
