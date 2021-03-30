package com.m.base.ui

import android.view.View

interface BaseClickTask {
    fun execute(view: View, position: Int)
}