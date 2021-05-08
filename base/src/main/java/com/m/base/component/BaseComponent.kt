package com.m.base.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseComponent<DB: ViewDataBinding, VM: BaseComponentViewModel<out BaseComponentViewData>> : ConstraintLayout {

    lateinit var dataBinding: DB
        private set
    lateinit var viewModel: VM
        private set

    constructor(context: Context): this(context, null)

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        initComponent(context)
    }

    open fun initComponent(context: Context) {
        viewModel = provideViewModel()
        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), provideLayoutId(), this, true)
        bindViewModel(dataBinding)
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel(viewDataBinding: DB)

    abstract fun provideLayoutId(): Int
}