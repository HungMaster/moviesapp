package com.it.hungvt.moviesapp.screen.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.source.MovieRepository;
import com.it.hungvt.moviesapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.moviesapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.moviesapp.databinding.ActivitySearchBinding;
import com.it.hungvt.moviesapp.screen.BaseActivity;

/**
 * Search Screen.
 */
public class SearchActivity extends BaseActivity {

    private SearchContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieRepository movieRepository =
                new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));

        mViewModel = new SearchViewModel(this);

        SearchContract.Presenter presenter = new SearchPresenter(mViewModel, movieRepository);
        mViewModel.setPresenter(presenter);

        ActivitySearchBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.setViewModel((SearchViewModel) mViewModel);
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
