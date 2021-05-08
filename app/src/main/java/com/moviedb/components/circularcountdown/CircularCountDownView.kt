package com.moviedb.components.circularcountdown

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.m.base.component.BaseComponent
import com.moviedb.R
import com.moviedb.databinding.ComponentLabelviewBinding

@BindingAdapter("viewData")
fun CircularCountDownView.setData(viewData: CircularCountDownViewData) {
    viewModel.handleInput(viewData)
}

class CircularCountDownView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : BaseComponent<ComponentLabelviewBinding, CircularCountDownViewModel>(context, attrs, defStyleAttr) {

    private var handler: CircularCountDownViewHandler? = null

    override fun provideViewModel() = CircularCountDownViewModel()

    override fun bindViewModel(viewDataBinding: ComponentLabelviewBinding) {
        viewDataBinding.viewModel = viewModel
    }

    override fun provideLayoutId() = R.layout.component_labelview

    override fun initComponent(context: Context) {
        super.initComponent(context)
        dataBinding.progressBar.setOnClickListener {
            handler?.handleClick()
        }
    }

    fun setHandler(handler: CircularCountDownViewHandler) {
        this.handler = handler
    }

}