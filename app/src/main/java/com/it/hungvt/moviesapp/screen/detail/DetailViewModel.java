package com.it.hungvt.moviesapp.screen.detail;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;
import com.it.hungvt.moviesapp.BR;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.Genre;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.screen.moviesactor.MoviesactorActivity;
import com.it.hungvt.moviesapp.screen.moviesgenre.MoviesgenreActivity;
import java.util.List;

public class DetailViewModel extends BaseObservable
        implements DetailContract.ViewModel, GenreAdapter.OnGenreItemClickListener,
        ActorAdapter.OnActorItemClickListener {

    private DetailContract.Presenter mPresenter;
    private Movie mMovie;
    private Context mContext;
    private String mKeyVideoTrailer;
    private ActorAdapter mActorAdapter;
    private ProductorAdapter mProductorAdapter;
    private GenreAdapter mGenreAdapter;

    public DetailViewModel(Context context, Movie movie) {
        mContext = context;
        mMovie = movie;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    public DetailContract.Presenter getPresenter() {
        return mPresenter;
    }

    public void onBackPress(View view) {
        ((Activity) view.getContext()).finish();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMovie(mMovie.getId());
        mPresenter.getVideoTrailer(mMovie.getId());
        mPresenter.getActorsByIdMovie(mMovie.getId());
    }

    @Bindable
    public Movie getMovie() {
        return mMovie;
    }

    public void setMovie(Movie movie) {
        mMovie = movie;
        notifyPropertyChanged(BR.movie);
    }

    @Override
    public void getMovieSuccess(Movie movie) {
        setMovie(movie);
        setGenreAdapter(new GenreAdapter(mContext, movie.getGenres()));
        setProductorAdapter(new ProductorAdapter(mContext, movie.getProductors()));
        mGenreAdapter.setListener(this);
    }

    @Bindable
    public String getKeyVideoTrailer() {
        return mKeyVideoTrailer;
    }

    public void setKeyVideoTrailer(String keyVideoTrailer) {
        mKeyVideoTrailer = keyVideoTrailer;
        notifyPropertyChanged(BR.keyVideoTrailer);
    }

    @Override
    public void getMovieFailure(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getTrailerSuccess(String keyVideoTrailer) {

        setKeyVideoTrailer(keyVideoTrailer);
    }

    @Override
    public void getTrailerFailure(String message) {

        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getActorByIdMovieSuccess(List<Actor> actors) {
        setActorAdapter(new ActorAdapter(mContext, actors));
        mActorAdapter.setListener(this);
    }

    @Override
    public void getActorByIdMovieFailure(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addMovieFavoriteSuccess(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void deleteMovieFavoriteSuccess(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public void onAddMovie() {
        mPresenter.addMovieToLocal(mMovie);
    }

    public void onDeleteMovie() {
        mPresenter.deleteMovieFromLocal(mMovie);
    }

    @Bindable
    public ActorAdapter getActorAdapter() {
        return mActorAdapter;
    }

    public void setActorAdapter(ActorAdapter actorAdapter) {
        mActorAdapter = actorAdapter;
        notifyPropertyChanged(BR.actorAdapter);
    }

    @Bindable
    public ProductorAdapter getProductorAdapter() {
        return mProductorAdapter;
    }

    public void setProductorAdapter(ProductorAdapter productorAdapter) {
        mProductorAdapter = productorAdapter;
        notifyPropertyChanged(BR.productorAdapter);
    }

    @Bindable
    public GenreAdapter getGenreAdapter() {
        return mGenreAdapter;
    }

    public void setGenreAdapter(GenreAdapter genreAdapter) {
        mGenreAdapter = genreAdapter;
        notifyPropertyChanged(BR.genreAdapter);
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void onGenreItemClick(Genre genre) {
        mContext.startActivity(MoviesgenreActivity.getIntent(mContext, genre));
    }

    @Override
    public void onActorItemClick(Actor actor) {
        mContext.startActivity(MoviesactorActivity.getIntent(mContext, actor));
    }
}

