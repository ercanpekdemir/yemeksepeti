package com.m.base.ui

interface BaseItem<Item> {

    fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean

    fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean
}