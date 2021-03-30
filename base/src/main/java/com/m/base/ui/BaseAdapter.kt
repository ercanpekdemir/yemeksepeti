package com.m.base.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<Item: BaseItem<Item>, DB: ViewDataBinding>(@LayoutRes private val layoutResId: Int):
    PagingDataAdapter<Item, BaseViewHolder<DB>>(BaseItemCallback<Item>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DB> {
        val binding: DB = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )


        return BaseViewHolder(binding, setClickListener(binding))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<DB>, position: Int) {
        getItem(position)?.let { bindItem(holder.binding, it) }
        holder.binding.executePendingBindings()
    }

    abstract fun bindItem(binding: DB, item: Item)

    abstract fun setClickListener(binding: DB): List<BaseAdapterClickListener>
}