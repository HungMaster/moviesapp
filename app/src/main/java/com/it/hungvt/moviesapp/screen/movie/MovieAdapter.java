package com.it.hungvt.moviesapp.screen.movie;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.databinding.ItemMovieBinding;
import java.util.List;

public class MovieAdapter extends BaseRecyclerViewAdapter<MovieAdapter.ItemViewHolder> {

    private List<Movie> mMovies;
    private ItemMovieBinding mBinding;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> mItemClickListener;

    public MovieAdapter(@NonNull Context context, List<Movie> movies) {
        super(context);
        mMovies = movies;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        mBinding = DataBindingUtil.inflate(mInflater, R.layout.item_movie, parent, false);

        return new ItemViewHolder(mBinding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return (mMovies == null) ? 0 : mMovies.size();
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Movie> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void updateMovies(List<Movie> movies) {
        if (movies == null) {
            return;
        }
        mMovies.addAll(movies);
        //        notifyItemInserted(mMovies.size() - 1);
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemMovieBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> mItemClickListener;

        public ItemViewHolder(ItemMovieBinding binding,
                BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> itemClickListener) {
            super(binding.getRoot());

            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bind(Movie movie) {
            mBinding.setItemViewModel(new MovieItemViewModel(movie, mItemClickListener));
            mBinding.setMovie(movie);
            mBinding.executePendingBindings();
        }
    }
}
