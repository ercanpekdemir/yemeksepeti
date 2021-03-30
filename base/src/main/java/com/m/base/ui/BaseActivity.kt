package com.m.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity <VM: BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: DB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, provideLayoutResId())
        val viewModel = bindViewModel(binding)
        observeProgressLiveData(viewModel)
    }

    open fun observeProgressLiveData(viewModel: VM) {
        viewModel.progressLiveData.observe(this) {
            if(it == true) {
                showLoading()
            } else {
                hideLoading()
            }
        }
    }

    abstract fun showLoading()

    abstract fun hideLoading()

    abstract fun provideLayoutResId(): Int

    abstract fun bindViewModel(db: DB): VM
}