package com.it.hungvt.moviesapp.screen.detail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.databinding.ItemGenreBinding;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by Administrator on 12/9/2017.
 */

public class GenreAdapter extends BaseRecyclerViewAdapter<GenreAdapter.ViewHolder> {

    private List<Genre> mGenres;
    private ItemGenreBinding mBinding;
    private OnGenreItemClickListener mListener;

    public GenreAdapter(@NonNull Context context, List<Genre> genres) {
        super(context);
        mGenres = genres;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.item_genre, parent, false);
        return new ViewHolder(mBinding, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return (mGenres == null) ? 0 : mGenres.size();
    }

    public void setListener(OnGenreItemClickListener listener) {
        mListener = listener;
    }

//        public void updateGenre(List<Genre> genres){
//            if (genres==null){
//                return;
//            }
//            mGenres.addAll(genres);
//            notifyDataSetChanged();
//        }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemGenreBinding mBinding;
        private OnGenreItemClickListener mListener;

        public ViewHolder(ItemGenreBinding binding, OnGenreItemClickListener listener) {
            super(binding.getRoot());
            mBinding = binding;
            mListener = listener;
        }

        public void bind(Genre genre) {
            if (genre != null) {
                mBinding.setGenre(genre);
                mBinding.setListener(mListener);
                mBinding.executePendingBindings();
            }
        }
    }

    public interface OnGenreItemClickListener {
        void onGenreItemClick(Genre genre);
    }
}
