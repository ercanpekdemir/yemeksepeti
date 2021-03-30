package com.m.base.ui

import androidx.recyclerview.widget.DiffUtil

class BaseItemCallback<Item: BaseItem<Item>>: DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) =
        oldItem.areItemsTheSame(oldItem, newItem)

    override fun areContentsTheSame(oldItem: Item, newItem: Item) =
        oldItem.areContentsTheSame(oldItem, newItem)
}