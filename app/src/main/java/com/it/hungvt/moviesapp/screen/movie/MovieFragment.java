package com.it.hungvt.moviesapp.screen.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.it.hungvt.moviesapp.screen.BaseFragment;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.moviesapp.databinding.FragmentMovieBinding;
import com.it.hungvt.moviesapp.utils.Constant;



public class MovieFragment extends BaseFragment {

    private MovieContract.ViewModel mViewModel;
    private MovieContract.Presenter mPresenter;
    private int mCategoryId;
    private int mId;
    private MovieRepository mMovieRepository;


    public static MovieFragment getInstance(int categoryId) {

        MovieFragment movieFragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.BUNDLE_CATEGORY_ID, categoryId);
        movieFragment.setArguments(bundle);
        return movieFragment;
    }

    public static MovieFragment getInstance(int categoryId, int id){
        MovieFragment movieFragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.BUNDLE_CATEGORY_ID,categoryId);
        bundle.putInt(Constant.BUNDLE_ID,id);
        movieFragment.setArguments(bundle);
        return movieFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMovieRepository =
                new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));

        mCategoryId = getArguments().getInt(Constant.BUNDLE_CATEGORY_ID);
        mId = getArguments().getInt(Constant.BUNDLE_ID);
        mViewModel = new MovieViewModel(getContext(), mCategoryId, mId);
        mPresenter = new MoviePresenter(mViewModel, mMovieRepository);
        mViewModel.setPresenter(mPresenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentMovieBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        binding.setMovieViewModel((MovieViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();

        super.onStop();
    }
}
