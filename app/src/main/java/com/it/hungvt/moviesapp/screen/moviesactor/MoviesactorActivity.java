package com.it.hungvt.moviesapp.screen.moviesactor;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.databinding.ActivityMoviesactorBinding;
import com.it.hungvt.moviesapp.screen.BaseActivity;
import com.it.hungvt.moviesapp.utils.Constant;

/**
 * Moviesactor Screen.
 */
public class MoviesactorActivity extends BaseActivity {

    private MoviesactorContract.ViewModel mViewModel;

    public static Intent getIntent(Context context, Actor actor){
        Intent intent = new Intent(context,MoviesactorActivity.class);
        intent.putExtra(Constant.BUNDLE_ACTOR,actor);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Actor actor = getIntent().getParcelableExtra(Constant.BUNDLE_ACTOR);
        FragmentManager manager = getSupportFragmentManager();

        mViewModel = new MoviesactorViewModel(getApplicationContext(),manager,actor);

        MoviesactorContract.Presenter presenter = new MoviesactorPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityMoviesactorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_moviesactor);
        binding.setViewModel((MoviesactorViewModel) mViewModel);
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
