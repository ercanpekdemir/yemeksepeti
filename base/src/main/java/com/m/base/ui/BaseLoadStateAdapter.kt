package com.m.base.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter

abstract class BaseLoadStateAdapter<DB: ViewDataBinding>(@LayoutRes private val layoutResId: Int):
    LoadStateAdapter<BaseViewHolder<DB>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<DB>, loadState: LoadState) {
//        getItem(position)?.let { bindItem(holder.binding, it) }
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): BaseViewHolder<DB> {
        val binding: DB = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )
        return BaseViewHolder(binding, setClickListener(binding))
    }

    abstract fun setClickListener(binding: DB): List<BaseAdapterClickListener>
}