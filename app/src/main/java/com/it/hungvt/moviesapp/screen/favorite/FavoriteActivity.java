package com.it.hungvt.moviesapp.screen.favorite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.source.FavoriteRepository;
import com.it.hungvt.moviesapp.data.source.local.FavoriteLocalDataSource;
import com.it.hungvt.moviesapp.databinding.ActivityFavoriteBinding;
import com.it.hungvt.moviesapp.screen.BaseActivity;

/**
 * Favorite Screen.
 */
public class FavoriteActivity extends BaseActivity {

    private FavoriteContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FavoriteRepository favoriteRepository =
                new FavoriteRepository(new FavoriteLocalDataSource(this));

        mViewModel = new FavoriteViewModel(this);

        FavoriteContract.Presenter presenter =
                new FavoritePresenter(mViewModel, favoriteRepository);
        mViewModel.setPresenter(presenter);

        ActivityFavoriteBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_favorite);
        binding.setViewModel((FavoriteViewModel) mViewModel);
        binding.setActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
