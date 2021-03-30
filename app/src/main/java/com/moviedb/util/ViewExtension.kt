package com.moviedb.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.moviedb.R

private val MIN_SEARCH_LEN = 2

@BindingAdapter( "app:src_glide")
fun ImageView?.setSrcGlide(path: String?) = this?.run {
    Glide.with(this)
        .load(path)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.error)
        .into(this)
}

@BindingAdapter( "app:backdrop_glide")
fun ConstraintLayout?.setBackdropGlide(path: String?) = this?.run {
    Glide.with(this)
        .load(path)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(ConstraintLayoutTarget(this))
}

fun View?.hideKeyboard() = this?.post {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText?.onTextUpdated(notifyOnInput: (text: String) -> Unit) {
    this?.addTextChangedListener(object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
        override fun afterTextChanged(s: Editable?) {
            val text = s?.toString() ?: ""
            if(text.length >= MIN_SEARCH_LEN) {
                notifyOnInput.invoke(text)
            }
        }

    })
}