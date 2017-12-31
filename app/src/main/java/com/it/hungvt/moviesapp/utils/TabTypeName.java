package com.it.hungvt.moviesapp.utils;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_ACTOR_ID;
import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_GENRE_ID;
import static com.it.hungvt.moviesapp.utils.TabTypeName.MOVIES_OF_PRODUCTOR_ID;
import static com.it.hungvt.moviesapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.moviesapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.moviesapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.moviesapp.utils.TabTypeName.UP_COMING;

/**
 * Created by Administrator on 12/2/2017.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        TOP_RATE, UP_COMING, NOW_PLAYING, POPULAR, MOVIES_OF_GENRE_ID, MOVIES_OF_ACTOR_ID,
        MOVIES_OF_PRODUCTOR_ID
})
public @interface TabTypeName {
    int TOP_RATE = 0;
    int UP_COMING = 1;
    int NOW_PLAYING = 2;
    int POPULAR = 3;
    int MOVIES_OF_GENRE_ID = 4;
    int MOVIES_OF_ACTOR_ID = 5;
    int MOVIES_OF_PRODUCTOR_ID = 6;
}
