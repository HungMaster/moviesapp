package com.it.hungvt.moviesapp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "MyFavoriteMovie.db";
    private static int DATA_BASE_VERSION = 1;

    private static final String CREATE_TABLE_MOVIE = "CREATE TABLE IF NOT EXISTS "
            + MovieDataContract.MovieEntry.TABLE_NAME
            + "("
            + MovieDataContract.MovieEntry.COLUMN_MOVIE_ID
            + " INTEGER PRIMARY KEY, "
            + MovieDataContract.MovieEntry.COLUMN_POSTER_PATH
            + " TEXT, "
            + MovieDataContract.MovieEntry.COLUMN_TITLE
            + " TEXT, "
            + MovieDataContract.MovieEntry.COLUMN_VOTE_AVERAGE
            + " FLOAT, "
            + MovieDataContract.MovieEntry.COLUMN_OVER_VIEW
            + " TEXT, "
            + MovieDataContract.MovieEntry.COLUMN_RELEASE_DATE
            + " TEXT"
            + ")";
    private static final String DELETE_TABLE_MOVIE =
            "DROP TABLE IF EXISTS " + MovieDataContract.MovieEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DELETE_TABLE_MOVIE);
        db.execSQL(CREATE_TABLE_MOVIE);
    }
}
