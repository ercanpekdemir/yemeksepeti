package com.m.base.ui

import android.view.View

class BaseAdapterClickListener(val clickType: BaseClickType, val view: View, val task: BaseClickTask) {
    constructor(view: View, task: BaseClickTask): this(BaseClickType.ON_CLICK, view, task)
}

enum class BaseClickType {
    ON_CLICK,
    ON_DELAYED_CLICK,
    ON_LONG_CLICK
}