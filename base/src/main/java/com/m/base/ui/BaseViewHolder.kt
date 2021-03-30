package com.m.base.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<DB: ViewDataBinding>(
    val binding: DB,
    clickListener: List<BaseAdapterClickListener>?
): RecyclerView.ViewHolder(binding.root) {

    init {
        if(clickListener?.isNullOrEmpty() == false) {
            handleClicks(clickListener)
        }
    }

    private fun handleClicks(clickListeners: List<BaseAdapterClickListener>) {
        clickListeners.forEach { listener ->
            when (listener.clickType) {
                BaseClickType.ON_CLICK -> {
                    listener.apply {
                        view.setOnClickListener {
                            task.execute(view, layoutPosition)
                        }
                    }
                }
                BaseClickType.ON_LONG_CLICK -> {
                    listener.apply {
                        view.setOnLongClickListener {
                            task.execute(view, layoutPosition)
                            true
                        }
                    }
                }
                BaseClickType.ON_DELAYED_CLICK -> {

                }
            }
        }
    }
}