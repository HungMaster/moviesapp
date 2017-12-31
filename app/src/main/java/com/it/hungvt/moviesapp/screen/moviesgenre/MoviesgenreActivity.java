package com.it.hungvt.moviesapp.screen.moviesgenre;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.databinding.ActivityMoviesgenreBinding;
import com.it.hungvt.moviesapp.screen.BaseActivity;
import com.it.hungvt.moviesapp.utils.Constant;

/**
 * Moviesgenre Screen.
 */
public class MoviesgenreActivity extends BaseActivity {

    private MoviesgenreContract.ViewModel mViewModel;

    public static Intent getIntent(Context context, Genre genre) {
        Intent intent = new Intent(context, MoviesgenreActivity.class);
        intent.putExtra(Constant.BUNDLE_GENRE, genre);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Genre genre = getIntent().getParcelableExtra(Constant.BUNDLE_GENRE);
        FragmentManager manager = getSupportFragmentManager();
        setTitle(genre.getName());
        mViewModel = new MoviesgenreViewModel(getApplicationContext(), manager, genre);

        MoviesgenreContract.Presenter presenter = new MoviesgenrePresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityMoviesgenreBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_moviesgenre);
        binding.setViewModel((MoviesgenreViewModel) mViewModel);
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
