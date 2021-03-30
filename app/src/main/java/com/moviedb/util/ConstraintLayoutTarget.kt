package com.moviedb.util

import android.graphics.drawable.Drawable
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class ConstraintLayoutTarget(private val constraintLayout: ConstraintLayout) : CustomTarget<Drawable>() {
    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        constraintLayout.background = resource
    }

    override fun onLoadCleared(placeholder: Drawable?) {

    }

}