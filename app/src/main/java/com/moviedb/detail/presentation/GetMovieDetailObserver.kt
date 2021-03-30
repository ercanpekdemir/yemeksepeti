package com.moviedb.detail.presentation

import com.m.base.BaseDisposableSingleObserver
import com.moviedb.detail.data.res.MovieDetailResponse

class GetMovieDetailObserver (private val movieDetailViewModel: MovieDetailViewModel)
    : BaseDisposableSingleObserver<MovieDetailResponse>(movieDetailViewModel) {

    override fun onResultSuccess(result: MovieDetailResponse) {
        movieDetailViewModel.handleMovies(result)
    }

    override fun onResultFail(e: Throwable) {
    }


}