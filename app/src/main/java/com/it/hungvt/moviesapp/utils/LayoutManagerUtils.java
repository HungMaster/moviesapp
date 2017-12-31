package com.it.hungvt.moviesapp.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 11/24/2017.
 */

public class LayoutManagerUtils {

    private LayoutManagerUtils() {

    }

    public static LayoutManager linearLayout() {
        return new LayoutManager() {
            @Override
            public RecyclerView.LayoutManager layout(RecyclerView recyclerView) {
                return new LinearLayoutManager(recyclerView.getContext());
            }
        };
    }

    public static LayoutManager linearLayoutHorizontal() {
        return new LayoutManager() {
            @Override
            public RecyclerView.LayoutManager layout(RecyclerView recyclerView) {
                return new LinearLayoutManager(recyclerView.getContext(),
                        LinearLayoutManager.HORIZONTAL, false);
            }
        };
    }

    public static LayoutManager gridLayout(int column) {

        return new LayoutManager() {
            @Override
            public RecyclerView.LayoutManager layout(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), column);
            }
        };
    }

    public interface LayoutManager {
        RecyclerView.LayoutManager layout(RecyclerView recyclerView);
    }
}
