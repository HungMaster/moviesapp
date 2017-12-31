package com.it.hungvt.moviesapp.screen.detail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.it.hungvt.moviesapp.R;
import com.it.hungvt.moviesapp.data.model.Actor;
import com.it.hungvt.moviesapp.data.model.Productor;
import com.it.hungvt.moviesapp.databinding.ItemActorBinding;
import com.it.hungvt.moviesapp.databinding.ItemProductorBinding;
import com.it.hungvt.moviesapp.screen.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by Administrator on 12/9/2017.
 */

public class ProductorAdapter extends BaseRecyclerViewAdapter<ProductorAdapter.ViewHolder> {
    private List<Productor> mProductors;
    private ItemProductorBinding mBinding;

    public ProductorAdapter(@NonNull Context context, List<Productor> productors) {
        super(context);
        mProductors = productors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.item_productor, parent, false);
        return new ViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mProductors.get(position));
    }

    @Override
    public int getItemCount() {
        return (mProductors == null) ? 0 : mProductors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemProductorBinding mBinding;

        public ViewHolder(ItemProductorBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Productor productor) {
            if (productor != null) {
                mBinding.setProductor(productor);
                mBinding.executePendingBindings();
            }
        }
    }
}
