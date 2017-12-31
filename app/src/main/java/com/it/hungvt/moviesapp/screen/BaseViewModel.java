package com.it.hungvt.moviesapp.screen;

/**
 * Created by Administrator on 11/14/2017.
 */

public interface BaseViewModel<T  extends BasePresenter> {

    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
