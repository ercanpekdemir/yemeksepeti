package com.moviedb.movie.presentation.adapter

import androidx.databinding.ViewDataBinding

interface MoviesClickHandler {
    fun onMovieLoadRetry()
    fun onMovieDetailOpen(binding: ViewDataBinding)
}