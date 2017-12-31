package com.it.hungvt.moviesapp.screen.detail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.databinding.ItemActorBinding;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by Administrator on 12/9/2017.
 */

public class ActorAdapter extends BaseRecyclerViewAdapter<ActorAdapter.ViewHolder> {
    private List<Actor> mActors;
    private ItemActorBinding mBinding;
    private OnActorItemClickListener mListener;

    public ActorAdapter(@NonNull Context context, List<Actor> actors) {
        super(context);
        mActors = actors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.item_actor, parent, false);
        return new ViewHolder(mBinding, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mActors.get(position));
    }

    @Override
    public int getItemCount() {
        return (mActors == null) ? 0 : mActors.size();
    }

    public void setListener(OnActorItemClickListener listener) {
        mListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemActorBinding mBinding;
        private OnActorItemClickListener mListener;

        public ViewHolder(ItemActorBinding binding, OnActorItemClickListener listener) {
            super(binding.getRoot());
            mBinding = binding;
            mListener = listener;
        }

        public void bind(Actor actor) {

            mBinding.setActor(actor);
            mBinding.setListener(mListener);
            mBinding.executePendingBindings();
        }
    }

    public interface OnActorItemClickListener {
        void onActorItemClick(Actor actor);
    }
}
