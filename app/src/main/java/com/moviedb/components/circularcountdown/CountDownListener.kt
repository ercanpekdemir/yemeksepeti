package com.moviedb.components.circularcountdown

interface CountDownListener {
    fun onTick(remainingTime: Int)
    fun onFinish()
}