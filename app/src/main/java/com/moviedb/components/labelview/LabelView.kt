package com.moviedb.components.labelview

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.m.base.component.BaseComponent
import com.moviedb.R
import com.moviedb.databinding.ComponentLabelviewBinding

@BindingAdapter("viewData")
fun LabelView.setData(viewData: LabelViewData) {
    viewModel.handleInput(viewData)
}

class LabelView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : BaseComponent<ComponentLabelviewBinding, LabelViewModel>(context, attrs, defStyleAttr) {

    override fun provideViewModel() = LabelViewModel()

    override fun bindViewModel(viewDataBinding: ComponentLabelviewBinding) {
        viewDataBinding.viewModel = viewModel
    }

    override fun provideLayoutId() = R.layout.component_labelview
}