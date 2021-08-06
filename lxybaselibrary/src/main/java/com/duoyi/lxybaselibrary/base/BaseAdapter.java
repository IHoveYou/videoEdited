package com.duoyi.lxybaselibrary.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 作者 lxy on Time 2020-08-1314:24.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public abstract class BaseAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<ViewHolder> {

    public Context mContext;
    public List<T> mList;
    int layoutId = 0;

   public OnItemClickListener onItemClickListener = new OnItemClickListener<T, B>() {
        @Override
        public void onItemClick(View view, B mBinding, RecyclerView.ViewHolder holder, int position, T bean) {

        }
    };

    public BaseAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mList = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layouts = initLayoutId(viewType);
        B mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), layouts, parent, false);
        return new ViewHolder(mContext, mBinding.getRoot()).setType(viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if (position > mList.size())
            return;
        final T bean = mList.get(position);
        final B binding = DataBindingUtil.getBinding(holder.itemView);
        holder.bean=bean;
        holder.binding=binding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(view, binding, holder, position, bean);
            }
        });
        bindingData(holder, binding, bean, holder.getType(), position);
        binding.executePendingBindings();
    }


    public int initLayoutId(int type) {
        return layoutId;
    }

    protected abstract void bindingData(ViewHolder holder, B mBinding, T bean, int type, int position);

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T, B extends ViewDataBinding> {
        void onItemClick(View view, B mBinding, RecyclerView.ViewHolder holder, int position, T bean);
    }

}
