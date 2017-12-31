package com.it.hungvt.moviesapp.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {

    private final Context mContext;

    protected BaseRecyclerViewAdapter(@NonNull Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public interface OnRecyclerViewItemClickListener<T> {

        void onItemRecyclerViewClick(T item);
    }
}
