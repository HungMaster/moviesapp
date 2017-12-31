package com.it.hungvt.moviesapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.it.hungvt.moviesapp.data.model.Movie;
import com.it.hungvt.moviesapp.data.source.FavoriteDataSource;
import com.it.hungvt.moviesapp.utils.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FavoriteLocalDataSource extends DatabaseHelper implements FavoriteDataSource {

    private SQLiteDatabase mSQLiteDatabase;

    public FavoriteLocalDataSource(Context context) {
        super(context);
    }

    private void openDatabase() {

        if (mSQLiteDatabase == null || !mSQLiteDatabase.isOpen()) {
            mSQLiteDatabase = getWritableDatabase();
        }
    }

    private void closeDatabase() {

        if (mSQLiteDatabase != null && mSQLiteDatabase.isOpen()) {
            mSQLiteDatabase.close();
        }
    }

    @Override
    public List<Movie> getMovies() {

        openDatabase();
        String sql = "SELECT * FROM "
                + MovieDataContract.MovieEntry.TABLE_NAME
                + " ORDER BY "
                + MovieDataContract.MovieEntry.COLUMN_TITLE
                + " ASC ";

        Cursor cursor = mSQLiteDatabase.rawQuery(sql, null);
        ArrayList<Movie> movies = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            closeDatabase();
            return movies;
        }

        cursor.moveToFirst();
        int columnIndexId = cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_MOVIE_ID);

        int columnIndexPosterPath =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_POSTER_PATH);

        int columnIndexTitle = cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_TITLE);
        int columnIndexVoteAverage =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_VOTE_AVERAGE);
        int columnIndexDate =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_RELEASE_DATE);
        int columnIndexOverView =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_OVER_VIEW);

        while (!cursor.isAfterLast()) {

            try {
                String posterPath = cursor.getString(columnIndexPosterPath);
                String title = cursor.getString(columnIndexTitle);
                String date = cursor.getString(columnIndexDate);
                String overView = cursor.getString(columnIndexOverView);
                Float voteAverage = cursor.getFloat(columnIndexVoteAverage);
                int id = cursor.getInt(columnIndexId);

                SimpleDateFormat dt = new SimpleDateFormat(Constant.FORMAT_DATE, Locale.US);
                Date releaseDate = dt.parse(date);
                movies.add(new Movie(id, title, voteAverage, posterPath, overView, releaseDate));

                cursor.moveToNext();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        cursor.close();
        closeDatabase();
        return movies;
    }

    @Override
    public boolean insertMovie(Movie movie) {

        openDatabase();

        ContentValues values = new ContentValues();
        values.put(MovieDataContract.MovieEntry.COLUMN_MOVIE_ID, movie.getId());
        values.put(MovieDataContract.MovieEntry.COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(MovieDataContract.MovieEntry.COLUMN_TITLE, movie.getTitle());
        values.put(MovieDataContract.MovieEntry.COLUMN_VOTE_AVERAGE, movie.getVoteAverage());
        values.put(MovieDataContract.MovieEntry.COLUMN_OVER_VIEW, movie.getOverview());
        values.put(MovieDataContract.MovieEntry.COLUMN_RELEASE_DATE, movie.getDate());

        long id = mSQLiteDatabase.insert(MovieDataContract.MovieEntry.TABLE_NAME, null, values);
        closeDatabase();
        return id != -1;
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        openDatabase();

        long id = mSQLiteDatabase.delete(MovieDataContract.MovieEntry.TABLE_NAME, "id=?",
                new String[] { String.valueOf(movie.getId()) });

        closeDatabase();
        return id != -1;
    }

    @Override
    public boolean checkMovieExists(Movie movie) {
        openDatabase();

        String sql = "SELECT * FROM "
                + MovieDataContract.MovieEntry.TABLE_NAME
                + " WHERE "
                + MovieDataContract.MovieEntry.COLUMN_MOVIE_ID
                + "=?";
        String[] selectionArgs = new String[] { String.valueOf(movie.getId()) };
        Cursor cursor = mSQLiteDatabase.rawQuery(sql, selectionArgs);

        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        closeDatabase();
        return false;
    }
}
