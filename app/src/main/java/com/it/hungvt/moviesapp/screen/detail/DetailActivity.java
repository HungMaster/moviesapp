package com.it.hungvt.moviesapp.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.FavoriteRepository;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.data.source.local.FavoriteLocalDataSource;
import com.it.hungvt.moviesapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.moviesapp.databinding.ActivityDetailBinding;
import com.it.hungvt.moviesapp.utils.Constant;

/**
 * Detail Screen.
 */
public class DetailActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private DetailContract.ViewModel mViewModel;

    public static Intent getIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constant.BUNDLE_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieRepository movieRepository =
                new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        FavoriteRepository favoriteRepository =
                new FavoriteRepository(new FavoriteLocalDataSource(getApplicationContext()));

        Movie movie = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            movie = bundle.getParcelable(Constant.BUNDLE_MOVIE);
        }
        mViewModel = new DetailViewModel(getApplicationContext(), movie);
        DetailContract.Presenter presenter = new DetailPresenter(getApplicationContext(),mViewModel, movieRepository,favoriteRepository);
        mViewModel.setPresenter(presenter);

        ActivityDetailBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel((DetailViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
            YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
            YouTubeInitializationResult youTubeInitializationResult) {

    }
}
