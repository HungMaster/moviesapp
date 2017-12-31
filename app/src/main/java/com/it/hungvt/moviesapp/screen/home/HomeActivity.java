package com.it.hungvt.moviesapp.screen.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.screen.BaseActivity;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.moviesapp.databinding.ActivityHomeBinding;

/**
 * Home Screen.
 */
public class HomeActivity extends BaseActivity {

    private HomeContract.ViewModel mViewModel;

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieRepository movieRepository = new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));

        mViewModel = new HomeViewModel(this,getSupportFragmentManager());

        HomeContract.Presenter presenter = new HomePresenter(mViewModel, movieRepository);
        mViewModel.setPresenter(presenter);

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewModel((HomeViewModel) mViewModel);
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

}
