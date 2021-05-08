package com.moviedb.components.circularcountdown

import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class CountDownUtil(millsInFuture: Long, interval: Long, listener: CountDownListener) :
    CountDownTimer(TimeUnit.SECONDS.toMillis(millsInFuture), TimeUnit.SECONDS.toMillis(interval)) {

    private var countDownListener: CountDownListener = listener

    override fun onTick(millisUntilFinished: Long) {
        val remainingTime = (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))).toInt()
        countDownListener.onTick(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished).toInt())
    }

    override fun onFinish() {
        countDownListener.onFinish()
    }

    fun clearTimer() {
        cancel()
    }
}